package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task

/**
 * Created by hugo on 9/3/18.
 */
class TaskRepository {

    companion object {
        private var TASK_LIST = arrayListOf(
                Task(0, "Take out the trash", "today", 1, true),
                Task(1, "Feed pets", "tomorrow", 2, false),
                Task(2, "Go to school", "some day", 2, false),
                Task(3, "Study for test", "eventually", 3, false)
        )

    }

    fun getTaskList(): List<Task> {
        return TASK_LIST
    }


    fun saveTask(task: Task) {
        TASK_LIST.add(task)
    }
}