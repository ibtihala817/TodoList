package com.example.todolist.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import java.text.SimpleDateFormat
import java.util.*


class AddTaskFragment : Fragment() {

   private val taskViewModel: TaskViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskEditText: EditText = view.findViewById(R.id.task_edittext)
        val taskDescriptionEditText: EditText = view.findViewById(R.id.taskdescriptipn_edittext)
        val taskDatePicker: DatePicker= view.findViewById(R.id.task_datepicker)
        val saveButton: Button = view.findViewById(R.id.save_button)

        saveButton.setOnClickListener{
            val task =  taskEditText.text.toString()
            val description = taskDescriptionEditText.text.toString()
            val datePicker = "${taskDatePicker.year}/${taskDatePicker.month+1}/${taskDatePicker.dayOfMonth} "
            val duedatetime = SimpleDateFormat("dd/M/yyyy hh:mm:ss" )
            Log.d("duedatetime", duedatetime.toString())
            if (task.isNotEmpty() && description.isNotEmpty()){

            taskViewModel.addItem(task,description,datePicker,duedatetime, false)
            findNavController().popBackStack()

        }
    }

    }}