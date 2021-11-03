package com.example.tasktimerapp.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="Timer_table")
data class EntityTimer(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id : Int = 0,

    @ColumnInfo(name = "TaskName")
    var name: String,

    @ColumnInfo (name = "TaskDiscription")
     var discrption: String,

   @ColumnInfo(name = "time")
   val time : Int = 0

)
