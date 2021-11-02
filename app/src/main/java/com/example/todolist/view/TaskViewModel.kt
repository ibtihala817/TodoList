package com.example.todolist.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.repository.TaskRepository
import com.example.todolist.taskdatabase.taskmodel.TaskModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class TaskViewModel : ViewModel() {

    private val taskRepository = TaskRepository.get()
    var taskItems = taskRepository.getItems()
   var selectedItemMutableLiveDate = MutableLiveData<TaskModel>()
   fun addItem(task: String,
               descripition: String,
               duedate: String,
               checkbox: Boolean){
       val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss" )

       val currentDate = sdf .format(Date())



       viewModelScope.launch {
           taskRepository.addItem(TaskModel(task,descripition,currentDate,duedate,checkbox))
       }

   }

    fun updateItem(taskModel: TaskModel){
        viewModelScope.launch {
            taskRepository.updateItem(taskModel)
        }

   }

    fun deleteItem(taskModel: TaskModel){
        viewModelScope.launch {
            taskRepository.deleteItem(taskModel)
        }
    }
}