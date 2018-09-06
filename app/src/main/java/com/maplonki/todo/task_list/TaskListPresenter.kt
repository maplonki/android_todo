package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task

/**
 * Created by hugo on 9/3/18.
 */
class TaskListPresenter(
        private val mRepository: TaskRepository,
        private val mTaskListView: TaskListContract.View
) : TaskListContract.ActionListener {

    override fun loadTaskList() {
        mTaskListView.showLoading(true)

        val list = requestTaskList()
        mTaskListView.showLoading(false)
        mTaskListView.showTaskList(list)
    }

    override fun filterTaskList(filter: String) {
        mTaskListView.showLoading(true)

        mTaskListView.showLoading(false)

        val filterList = requestTaskList(filter)

        mTaskListView.showTaskList(filterList)
    }

    fun requestTaskList(filter: String = "none "): List<Task> {
        val list = mRepository.getTaskList()

        return when (filter) {
            "completed" -> list.filter { it.completed }
            else -> list
        }
    }

    override fun openTaskNew() {
        mTaskListView.showTaskNew()
    }

    override fun openTaskDetail(taskId: Long) {
        mTaskListView.showTaskDetail(taskId)
    }

}