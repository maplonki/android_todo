package com.maplonki.todo.task_create

import com.maplonki.todo.model.Task
import com.maplonki.todo.task_list.TaskRepository

/**
 * Created by hugo on 9/7/18.
 */
class TaskCreatePresenter(
        private val taskRepository: TaskRepository,
        private val taskCreateView: TaskCreateContract.View
) : TaskCreateContract.ActionListener {

    override fun saveNote(task: String) {
        if (task.isEmpty()) {
            taskCreateView.showEmptyError()
            return
        }

        val taskModel = Task(0, task, "today", 1)
        taskRepository.saveTask(taskModel)
        taskCreateView.showTaskList()
    }

}
