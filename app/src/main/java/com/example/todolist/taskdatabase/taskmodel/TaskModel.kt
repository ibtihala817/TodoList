package com.example.todolist.taskdatabase.taskmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class TaskModel(
    var task: String,
    var descripition: String,
    val date: String,
    var duedaue: String,
    var checkbox: Boolean,
    @PrimaryKey(autoGenerate = true)
 val id: Int = 0
)