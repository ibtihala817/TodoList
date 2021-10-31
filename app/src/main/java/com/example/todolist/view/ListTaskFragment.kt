package com.example.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.taskdatabase.taskmodel.TaskModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListTaskFragment : Fragment() {
      private val taskItems = mutableListOf<TaskModel>()
     private val taskViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_task, container, false)
    }

          override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
         val taskRecyclerView: RecyclerView = view.findViewById(R.id.task_recycler)
         val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
         val taskAdapter = TaskAdapter(taskItems,taskViewModel)
         taskRecyclerView.adapter = taskAdapter
          taskViewModel.taskItems.observe(viewLifecycleOwner, {
       it?.let {
          taskItems.clear()
           taskItems.addAll(it)
           taskAdapter.notifyDataSetChanged()
       }
       })
       addFloatingActionButton.setOnClickListener {
           findNavController().navigate(R.id.action_listTaskFragment_to_addTaskFragment)
       }
   }
}