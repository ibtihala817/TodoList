package com.example.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.taskdatabase.taskmodel.TaskModel


class TaskDetialsFragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels()
    private lateinit var selectedItem: TaskModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detials, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskTextView: TextView = view.findViewById(R.id.task_textview)
        val descripitionTextView: TextView = view.findViewById(R.id.descripition_textview)
        val duedateTextView: TextView = view.findViewById(R.id.duedate_textview)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
        val editButton: Button = view.findViewById(R.id.edit_button)
        taskViewModel.selectedItemMutableLiveDate.observe(viewLifecycleOwner,{
            it?.let { item ->
                taskTextView.text = item.task
                descripitionTextView.text = item.descripition
                duedateTextView.text = item.duedaue
                selectedItem = item
            }
        })
        deleteButton.setOnClickListener {
            taskViewModel.deleteItem(selectedItem)

        findNavController().popBackStack()
    }

        editButton.setOnClickListener {
            taskViewModel.updateItem(selectedItem)
        }
}}

