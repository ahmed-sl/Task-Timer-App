package com.example.tasktimerapp.RoomDB

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface TimerDao {

    @Insert
  suspend  fun insertTask(name:EntityTimer)

    @Query("SELECT * FROM timer_table")
   suspend fun getAll(): List<EntityTimer>


    @Update
   suspend fun updateTask(name: EntityTimer)





}