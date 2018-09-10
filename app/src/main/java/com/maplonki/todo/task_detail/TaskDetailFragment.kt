package com.maplonki.todo.task_detail

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.maplonki.todo.R
import com.maplonki.todo.task_list.TaskRepository
import kotlinx.android.synthetic.main.fragment_task_detail.*

/**
 * Created by hugo on 9/6/18.
 */
class TaskDetailFragment : Fragment(), TaskDetailContract.View {

    private val taskDescription: TextView  by lazy { task_detail_tv_description }
    private val taskDate: TextView by lazy { task_detail_tv_date }
    private val taskError: TextView by lazy { task_detail_tv_error }

    val taskDetailPresenter = TaskDetailPresenter(TaskRepository(), this)

    var taskId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskId = arguments.getLong("task_id")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_task_detail, container, false) ?: throw RuntimeException("Could not inflate view")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskDetailPresenter.initViews(taskId)
    }

    override fun showTaskDescription(description: String) {
        taskDescription.text = description
    }

    override fun showTaskDate(date: String) {
        taskDate.text = date
    }

    override fun showTaskNotFoundError() {
        taskError.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance(taskId: Long): TaskDetailFragment {
            val args = Bundle().apply {
                putLong("task_id", taskId)
            }
            return TaskDetailFragment().apply {
                arguments = args
            }
        }
    }
}
