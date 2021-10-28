package com.example.todolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RemoteViews
import androidx.lifecycle.MutableLiveData
import com.example.todolist.R
import com.example.todolist.repository.TaskRepository
import com.example.todolist.taskdatabase.taskmodel.TaskModel

class TaskAdapter(val items:List<TaskModel>, val viewModel: TaskViewModel):
RemoteViews.<TaskAdapter.TaskViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {

        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )


}