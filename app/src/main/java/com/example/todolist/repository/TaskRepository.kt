package com.example.todolist.repository

import android.content.Context
import androidx.room.Room
import com.example.todolist.taskdatabase.TaskDatabase
import com.example.todolist.taskdatabase.taskmodel.TaskModel

private const val DATABASE_NAME = "task-database"
class TaskRepository(context: Context) {
    private val database : TaskDatabase =
        Room.databaseBuilder(context,TaskDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    private val taskDao = database.taskDao()
    fun getItems() = taskDao.getItem()
    suspend fun addItem(taskModel: TaskModel)= taskDao.addItem(taskModel)
    suspend fun updateItem(taskModel: TaskModel)= taskDao.updateItem(taskModel)
    suspend fun deleteItem(taskModel: TaskModel)=taskDao.deleteItem(taskModel)

   companion object{
       private var instance: TaskRepository?= null
       fun init(context: Context){
           if ( instance == null)
               instance = TaskRepository(context)
       }
       fun get(): TaskRepository{
           return instance?: throw Exception(" Task Repository must be initialized")
       }
   }
}