package com.example.todolist.taskdatabase.taskmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class TaskModel(
 val task: String,
 val descripition: String,
 val date: String,
 val duedaue: String,
 var checkbox: Boolean,
 @PrimaryKey(autoGenerate = true)
 val id: Int = 0
)