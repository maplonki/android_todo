package com.maplonki.todo.task_list

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.maplonki.todo.R
import com.maplonki.todo.model.Task
import com.maplonki.todo.task_create.TaskCreateActivity
import com.maplonki.todo.task_detail.TaskDetailActivity
import kotlinx.android.synthetic.main.fragment_task_list.*

/**
 * Created by hugo on 9/3/18.
 */
class TaskListFragment : Fragment(), TaskListContract.View {

    private val mRecyclerView: RecyclerView by lazy { main_recyclerview }
    private val mProgressBar: ProgressBar by lazy { main_progressbar }
    private val mCreateTaskButton: FloatingActionButton by lazy { main_btn_create }

    private lateinit var mTaskListAdapter: TaskListAdapter
    private val mTaskActionListener: TaskListContract.ActionListener = TaskListPresenter(TaskRepository(), this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_task_list, container, false) ?: throw RuntimeException("Could not inflate view")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCreateTaskButton.setOnClickListener { mTaskActionListener.openTaskNew() }

        mTaskListAdapter = TaskListAdapter(activity) { task ->
            mTaskActionListener.openTaskDetail(task.taskId)
        }

        mRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = mTaskListAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        mTaskActionListener.loadTaskList()
    }

    override fun showLoading(showLoading: Boolean) {
        mProgressBar.visibility = if (showLoading) View.VISIBLE else View.GONE
    }

    override fun showTaskList(taskList: List<Task>) {
        mTaskListAdapter.updateItems(taskList)
    }

    override fun showTaskNew() {
        startActivity(Intent(activity, TaskCreateActivity::class.java))
    }

    override fun showTaskDetail(taskId: Long) {
        val intent = Intent(activity, TaskDetailActivity::class.java).apply {
            putExtra("task_id", taskId)
        }

        startActivity(intent)
    }

    companion object {
        fun newInstance() = TaskListFragment()
    }

}