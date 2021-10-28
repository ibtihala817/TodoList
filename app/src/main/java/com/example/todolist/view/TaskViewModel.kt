package com.example.todolist.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.repository.TaskRepository
import com.example.todolist.taskdatabase.taskmodel.TaskModel
import kotlinx.coroutines.launch
import java.util.*

class TaskViewModel : ViewModel() {
    private val taskRepository = TaskRepository.get()
    var taskItems = taskRepository.getItems()
   // var selectedItemMutableLiveDate = MutableLiveData<TaskModel>()
   fun addItem(task: String,
               descripition: String,
               date: String,
               duedate: String,
               checkbox: Boolean){
       viewModelScope.launch {
           taskRepository.addItem(TaskModel(task,descripition,date,duedate,checkbox))
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
}