package com.example.todolist.view

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.taskdatabase.taskmodel.TaskModel
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(val items:List<TaskModel>, val viewModel: TaskViewModel):
RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val taskTextView: TextView = view.findViewById(R.id.tesk_textviewDisplay)
        val duedateTextView:TextView= view.findViewById(R.id.duedatetextview)
        var checkBox: CheckBox = view.findViewById(R.id.checkBox)
        val deletebutton: ImageButton = view.findViewById(R.id.delete_buttonList)
        val editbutton: ImageButton= view.findViewById(R.id.edit_button)
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
        holder.duedateTextView.text = item.duedaue
        holder.checkBox.isChecked = item.checkbox
        holder.deletebutton.setOnClickListener(){
            viewModel.deleteItem(item)

        }
        holder.editbutton.setOnClickListener {

            viewModel.selectedItemMutableLiveDate.postValue(item)
            it.findNavController().navigate(R.id.action_listTaskFragment_to_taskDetialsFragment)
        }
        holder.itemView.setOnClickListener(){
            viewModel.selectedItemMutableLiveDate.postValue(item)
            it.findNavController().navigate(R.id.action_listTaskFragment_to_taskDetialsFragment)

        }

        var currentDate = Date()
        val format = SimpleDateFormat("yyyy/MM/dd")
        val deadline = format.parse(item.duedaue)
        if (currentDate > deadline){
            holder.taskTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        holder.checkBox.setOnClickListener {
            item.checkbox = holder.checkBox.isChecked
            viewModel.updateItem(item)

            if(holder.checkBox.isChecked){
                holder.taskTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
            }
            else
            {
                holder.taskTextView.setPaintFlags(0)
            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }
}