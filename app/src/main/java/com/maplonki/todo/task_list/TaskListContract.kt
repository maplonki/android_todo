package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task

/**
 * Created by hugo on 9/3/18.
 */
interface TaskListContract {

    interface View {
        fun showLoading(showLoading: Boolean)
        fun showTaskList(taskList: List<Task>)
        fun showTaskNew()
        fun showTaskDetail(taskId: Long)
    }

    interface ActionListener {
        fun loadTaskList()
        fun filterTaskList(filter: String)
        fun openTaskNew()
        fun openTaskDetail(taskId: Long)
    }
}