package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.RoomDB.TasksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewTask : AppCompatActivity() {

    //our views
    lateinit var tvWelcome:TextView
    lateinit var recyclerview: RecyclerView
    lateinit var btnSummaryTask:Button
    //our database
    lateinit var tasksDB: TasksDatabase
    //our variables
    var isBtnSumarryClick=false
    var running = false
    var pauseOffset: Long = 0
    var taskTime=""
    var num = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)
        //our views
        tvWelcome=findViewById(R.id.tvWelcome)
        recyclerview=findViewById(R.id.RVv)
        btnSummaryTask=findViewById(R.id.btnSummaryTask)
        //our database
        tasksDB= TasksDatabase.getInstance(this)

        //call needed methods
        getTasks()

        //do btn's listener
        btnSummaryTask.setOnClickListener {
            isBtnSumarryClick=true
            getTasks()
        }

    }//end onCreat()

   fun getTasks(){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
                if (!tasksDB.getTasksDao().getAll().isNullOrEmpty()) {
                    recyclerview.adapter=Adapter(this@ViewTask, tasksDB.getTasksDao().getAll())
                    recyclerview.layoutManager=LinearLayoutManager(this@ViewTask)
                }////write else part
            }
        }//end CoroutineScope
    }//end getTasks()

    fun updateTime(id:Int,time:String){
        CoroutineScope(Dispatchers.IO).launch {
            tasksDB.getTasksDao().updateTaskTime(id, time)
        }
    }//end updateTime()
    ////////////////////////Adapter method//////////////////////////
    fun Timer(chronometer: Chronometer) {
        chronometer.setFormat("Time: %s")
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.onChronometerTickListener =
            Chronometer.OnChronometerTickListener { chronometer ->
                if (SystemClock.elapsedRealtime() - chronometer.base >= 100000000) {
                    chronometer.base = SystemClock.elapsedRealtime()
                }//end startTimer
            }
    }//end Timer
    fun pasuse(chronometer: Chronometer, TaskId:Int):Boolean {
        var ishideLL2RV=false
        if (num==2){
            if (running){
                chronometer.stop();
                running = false;
                num--
                ishideLL2RV=true
                taskTime=chronometer.text.toString()
                updateTime(TaskId, taskTime)
            }//end if
        }
        return ishideLL2RV
    }//end pasuse

    fun start(chronometer: Chronometer, taskName:String){
        var runningTask = ""
        if (num == 1) {
            if (!running) {
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                running = true;
                num++
                runningTask = taskName
            } else {
                Toast.makeText(applicationContext, "Please finish/stop $runningTask first", Toast.LENGTH_SHORT).show()
            }
        }
    }//end start()

}//end class

