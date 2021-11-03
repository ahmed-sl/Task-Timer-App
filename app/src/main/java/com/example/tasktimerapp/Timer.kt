package com.example.tasktimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import com.example.tasktimerapp.RoomDB.TasksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Timer : AppCompatActivity() {
    //our views
    lateinit var chronometer: Chronometer
    lateinit var startbutton:Button
    lateinit var stopbutton:Button
    lateinit var pausebutton:Button
    //our variables
    private var running = false
    private var pauseOffset: Long = 0
    //our database
    lateinit var tasksDB: TasksDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        //my views
        chronometer=findViewById(R.id.chronometer)
        startbutton=findViewById(R.id.startbutton)
        stopbutton=findViewById(R.id.stopbutton)
        pausebutton=findViewById(R.id.pausebutton)
        //our database
        tasksDB= TasksDatabase.getInstance(this)

        //get task id in order to insert(update) its time to it
        var taskId= intent?.getIntExtra("taskID",0)
        var taskTime=""

        //chronometer
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.onChronometerTickListener =
            Chronometer.OnChronometerTickListener { chronometer ->
                if (SystemClock.elapsedRealtime() - chronometer.base >= 10000) {
                    chronometer.base = SystemClock.elapsedRealtime()
                    Toast.makeText(this, "Bing!", Toast.LENGTH_SHORT).show()
                }
            }

        ////do btn's listener
        startbutton.setOnClickListener {
            if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }}

        stopbutton.setOnClickListener {
            if (running){
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
                taskTime=chronometer.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    tasksDB.getTasksDao().updateTaskTime(taskId!!, taskTime)
                }
            }//end if
        }

        pausebutton.setOnClickListener {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }//end onCreate()

}//end class