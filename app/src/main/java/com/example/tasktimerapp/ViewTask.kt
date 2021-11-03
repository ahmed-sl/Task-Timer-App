package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktimerapp.RoomDB.TasksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewTask : AppCompatActivity() {

    //our views
    lateinit var recyclerview: RecyclerView
    lateinit var btnSummaryTask:Button
    //our database
    lateinit var tasksDB: TasksDatabase
    //our variables
    var isBtnSumarryClick=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)
        //our views
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

}