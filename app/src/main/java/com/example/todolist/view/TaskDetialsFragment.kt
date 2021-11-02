package com.example.todolist.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.taskdatabase.taskmodel.TaskModel
import com.google.android.material.datepicker.MaterialDatePicker


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

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskTextView: EditText= view.findViewById(R.id.taskEditText)
        val descripitionTextView: EditText = view.findViewById(R.id.DescripitionEditText)
        val duedateTextView: EditText = view.findViewById(R.id.DueDateEditText)
        val saveeditText : Button = view.findViewById(R.id.save_editbutton)
        taskViewModel.selectedItemMutableLiveDate.observe(viewLifecycleOwner,{
            it?.let { item ->
                taskTextView.setText(item.task)
                descripitionTextView.setText(item.descripition)
                duedateTextView.setText(item.duedaue)
                selectedItem = item
            }
        })
        saveeditText.setOnClickListener {
            selectedItem.task = taskTextView.text.toString()
            selectedItem.descripition = descripitionTextView.text.toString()
            selectedItem.duedaue = duedateTextView.text.toString()
            taskViewModel.updateItem(selectedItem)
            findNavController().popBackStack()
        }
        val dateRangePicker = DatePickerDialog(requireActivity())
        duedateTextView.setOnClickListener {

            dateRangePicker.show()

        }
        
        dateRangePicker.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ ->
            duedateTextView.setText("${dateRangePicker.datePicker.year}/" +
                    "${dateRangePicker.datePicker.month}/" +
                    "${dateRangePicker.datePicker.dayOfMonth}")
        }

    }}

