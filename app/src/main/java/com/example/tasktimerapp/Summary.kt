package com.example.tasktimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Summary : AppCompatActivity() {
    lateinit var tasksummaryview:TextView
    lateinit var timersummaryview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        tasksummaryview=findViewById(R.id.taskviewsummary)
        timersummaryview=findViewById(R.id.timersummaryview)
    }
}