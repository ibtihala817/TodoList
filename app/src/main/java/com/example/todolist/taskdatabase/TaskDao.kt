package com.example.todolist.taskdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.taskdatabase.taskmodel.TaskModel

@Dao
interface TaskDao {
@Insert
suspend fun addItem(taskModel: TaskModel)
    @Query("SELECT * FROM taskmodel")
    fun getItem(): LiveData<List<TaskModel>>
    @Update
    suspend fun updateItem(taskModel: TaskModel)
    @Delete
    suspend fun deleteItem(taskModel: TaskModel)
}