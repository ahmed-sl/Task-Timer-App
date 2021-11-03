package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddTask : AppCompatActivity() {
    lateinit var nametask:EditText
    lateinit var descriptiontask:EditText
    lateinit var savetask:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        nametask=findViewById(R.id.taskname)
        descriptiontask=findViewById(R.id.taskdescription)
        savetask=findViewById(R.id.savetask)

        savetask.setOnClickListener {
            var intent = Intent(applicationContext, ViewTask::class.java)
            startActivity(intent) }


    }
}