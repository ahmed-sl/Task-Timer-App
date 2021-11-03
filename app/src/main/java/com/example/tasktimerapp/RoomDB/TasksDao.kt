package com.example.tasktimerapp.RoomDB

import androidx.room.*

@Dao
interface TasksDao {

  @Insert
  fun insertTask(name:TasksTable)

  @Query("SELECT * FROM Tasks_table")
  fun getAll(): List<TasksTable>

   @Update
   fun updateTask(name: TasksTable)

   @Query("UPDATE Tasks_table SET TaskTime=:taskTime WHERE ID= :taksId")
   fun updateTaskTime(taksId:Int,taskTime:String)


}