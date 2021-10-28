package com.example.todolist.taskdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.taskdatabase.taskmodel.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}