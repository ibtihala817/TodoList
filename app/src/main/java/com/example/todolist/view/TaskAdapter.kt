package com.example.todolist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RemoteViews
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.repository.TaskRepository
import com.example.todolist.taskdatabase.taskmodel.TaskModel

class TaskAdapter(val items:List<TaskModel>, val viewModel: TaskViewModel):
RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val taskTextView: TextView = view.findViewById(R.id.task_textview)
        val descripitionTextView:TextView= view.findViewById(R.id.descripition_textview)
        val duedateTextView: TextView = view.findViewById(R.id.duedate_textview)
        var checkBox: CheckBox = view.findViewById(R.id.checkBox)
        val deletebutton: Button = view.findViewById(R.id.delete_button)
        val editbutton: Button= view.findViewById(R.id.edit_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = items[position]
        holder.taskTextView.text = item.task
        holder.descripitionTextView.text = item.descripition
        holder.duedateTextView.text = item.duedaue.toString()
        holder.checkBox.isChecked = item.checkbox
        holder.deletebutton.setOnClickListener(){

        }
        holder.editbutton.setOnClickListener(){
        viewModel.selectedItemMutableLiveDate.postValue(item)
            it.findNavController().navigate(R.id.action_listTaskFragment_to_taskDetialsFragment)
        }
        holder.checkBox.setOnClickListener {
            item.checkbox = holder.checkBox.isChecked
            viewModel.updateItem(item)
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }
}