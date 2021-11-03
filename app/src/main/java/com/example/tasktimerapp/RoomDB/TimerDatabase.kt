package com.example.tasktimerapp.RoomDB
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class TimerDatabase : RoomDatabase() {

    companion object{
        var instance:TimerDatabase?=null

         fun getInstance(context: Context):TimerDatabase {


             if(instance!=null){
                return instance as TimerDatabase
            }


            instance= Room.databaseBuilder(context,TimerDatabase::class.java, "data").run {allowMainThreadQueries()}.build();


            return instance as TimerDatabase
        }
    }
    abstract fun getTimerDao():TimerDao
}