package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tasktimerapp.RoomDB.TasksDatabase

class TimerHome : AppCompatActivity() {
    //our views
    lateinit var addtaskbutton:Button
    lateinit var viewtaskbutton:Button
    //our database
    lateinit var tasksDB: TasksDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_home)
        //our views
        addtaskbutton=findViewById(R.id.addtaskbutton)
        viewtaskbutton=findViewById(R.id.viewtaskbutton)
        //our database
        tasksDB= TasksDatabase.getInstance(this)

        //do btn's listener
        addtaskbutton.setOnClickListener {
             intent = Intent(this, AddTask::class.java)
            startActivity(intent) }

        viewtaskbutton.setOnClickListener {
            //first check if task table is empty and do an action
            if (!tasksDB.getTasksDao().getAll().isNullOrEmpty()) {
                intent = Intent(this, ViewTask::class.java)
                startActivity(intent)
            }else
                Toast.makeText(applicationContext, "There is no task yet, add task first! ", Toast.LENGTH_SHORT).show()
        }
    }//end onCreate()

}//end class