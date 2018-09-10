package com.maplonki.todo.task_detail

import com.maplonki.todo.task_list.TaskRepository

/**
 * Created by hugo on 9/10/18.
 */
class TaskDetailPresenter(
        val taskRepository: TaskRepository,
        val taskDetailView: TaskDetailContract.View
) : TaskDetailContract.ActionListener {


    override fun initViews(taskId: Long) {
        val task = taskRepository.getTask(taskId)

        if (task == null) {
            taskDetailView.showTaskNotFoundError()
        } else {
            taskDetailView.showTaskDescription(task.description)
            taskDetailView.showTaskDate(task.date)
        }
    }


}
