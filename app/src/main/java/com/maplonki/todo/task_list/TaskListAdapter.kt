package com.maplonki.todo.task_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.maplonki.todo.R
import com.maplonki.todo.model.Task


/**
 * Created by hugo on 9/3/18.
 */
class TaskListAdapter(
        private val context: Context,
        private var taskList: List<Task> = listOf(),
        private val onTaskClick: (Task) -> Unit)
    : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListAdapter.ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListAdapter.ViewHolder, position: Int) {
        val task = taskList[position]

        holder.descriptionTextView.text = task.description
    }

    fun updateItems(list: List<Task>) {
        taskList = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = taskList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descriptionTextView: TextView = view.findViewById(R.id.item_task_description)
    }

}