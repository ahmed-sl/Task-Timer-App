package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tasktimerapp.RoomDB.TasksDatabase
import com.example.tasktimerapp.RoomDB.TasksTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//here users should be able to add tasks as many as they need, then they should be able to go bask

class AddTask : AppCompatActivity() {
    //our views
    lateinit var nametask:EditText
    lateinit var descriptiontask:EditText
    lateinit var savetask:Button
    //our database
    lateinit var tasksDB: TasksDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        //my views
        nametask=findViewById(R.id.taskname)
        descriptiontask=findViewById(R.id.taskdescription)
        savetask=findViewById(R.id.savetask)
        //our database
        tasksDB= TasksDatabase.getInstance(this)
        //do btn's listener
        savetask.setOnClickListener {
            if (nametask.text.isNotEmpty() && descriptiontask.text.isNotEmpty()){
                var taskName=nametask.text.toString(); var taskDes=descriptiontask.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    tasksDB.getTasksDao().insertTask(TasksTable(0,taskName,taskDes,""))
                }//end CoroutineScope
                Toast.makeText(applicationContext, "Task saved successfully!", Toast.LENGTH_SHORT).show()
                nametask.text.clear(); descriptiontask.text.clear()
            }else
                Toast.makeText(applicationContext, "Please fill all entries!", Toast.LENGTH_SHORT).show()
        }//end savetask Listener


    }//end onCreate()

}//end class