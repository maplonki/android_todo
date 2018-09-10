package com.maplonki.todo.task_detail

/**
 * Created by hugo on 9/10/18.
 */
interface TaskDetailContract {

    interface View {
        fun showTaskDescription(description: String)
        fun showTaskDate(date: String)
        fun showTaskNotFoundError()
    }

    interface ActionListener {
        fun initViews(taskId: Long)
    }
}