package com.maplonki.todo.task_list

/**
 * Created by hugo on 9/3/18.
 */
class TaskListPresenter(
        private val mRepository: TaskRepository,
        private val mTaskListView: TaskListContract.View
) : TaskListContract.ActionListener {

    override fun loadTaskList() {
        mTaskListView.showLoading(true)

        mRepository.getTaskList { list ->
            mTaskListView.showLoading(false)
            mTaskListView.showTaskList(list)
        }
    }

    override fun filterTaskList(filter: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openTaskNew() {
        mTaskListView.showTaskNew()
    }

    override fun openTaskDetail(taskId: Long) {
        mTaskListView.showTaskDetail(taskId)
    }

}