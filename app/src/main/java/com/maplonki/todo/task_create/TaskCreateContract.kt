package com.maplonki.todo.task_create

/**
 * Created by hugo on 9/7/18.
 */
interface TaskCreateContract {

    interface View {
        fun showEmptyError()
        fun showTaskList()
    }

    interface ActionListener {
        fun saveNote(task: String)
    }
}