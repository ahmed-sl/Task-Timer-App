package com.example.tasktimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class Timer : AppCompatActivity() {
    lateinit var timerview:TextView
    lateinit var startbutton:Button
    lateinit var stopbutton:Button
    lateinit var pausebutton:Button
    //Declare a variable to hold count down timer's paused status
    private var isCanceled = false
    //Declare a variable to hold CountDownTimer remaining time
    private var timeRemaining: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        timerview=findViewById(R.id.timerview)
        startbutton=findViewById(R.id.startbutton)
        stopbutton=findViewById(R.id.stopbutton)
        pausebutton=findViewById(R.id.pausebutton)


        startbutton.setOnClickListener {  }
        stopbutton.setOnClickListener {  }
        pausebutton.setOnClickListener {  }




    }

/*

    fun countDownTimer(): CountDownTimer? {
        isCanceled = false;
        val millisInFuture: Long = 30000 //30 seconds
        val countDownInterval: Long = 1000 //1 second

        return object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                if (isCanceled){
                    cancel()

                }else{
                    timerview.setText("Time: " + millisUntilFinished / 1000)
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }

            }
            override fun onFinish() {
                timerview.setText("Time: -")

            }
        }.start()
    }//end countDownTimer()
*/




}