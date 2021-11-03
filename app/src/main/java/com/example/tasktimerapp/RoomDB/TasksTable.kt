package com.example.tasktimerapp.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="Tasks_table")
data class TasksTable(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id : Int = 0,

    @ColumnInfo(name = "TaskName")
    var name: String,

    @ColumnInfo (name = "TaskDescription")
     var discrption: String,

   @ColumnInfo(name = "TaskTime")
   val time : String

)
