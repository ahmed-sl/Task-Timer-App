package com.example.tasktimerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TimerHome : AppCompatActivity() {
    lateinit var addtaskbutton:Button
    lateinit var viewtaskbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_home)
        addtaskbutton=findViewById(R.id.addtaskbutton)
        viewtaskbutton=findViewById(R.id.viewtaskbutton)

        addtaskbutton.setOnClickListener {
            var intent = Intent(applicationContext, AddTask::class.java)
            startActivity(intent) }
        viewtaskbutton.setOnClickListener {    var intent = Intent(applicationContext, ViewTask::class.java)
            startActivity(intent) }


    }
}