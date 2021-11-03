package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ViewTask : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var AddTaskbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)
        recyclerview=findViewById(R.id.RVv)
        AddTaskbutton=findViewById(R.id.addtask)

        AddTaskbutton.setOnClickListener {


            var intent = Intent(applicationContext, Summary::class.java)
            startActivity(intent)
        }

    }
}