package com.maplonki.todo.task_create

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.maplonki.todo.R
import com.maplonki.todo.task_list.TaskRepository
import kotlinx.android.synthetic.main.fragment_task_create.*

/**
 * Created by hugo on 9/6/18.
 */
class TaskCreateFragment : Fragment(), TaskCreateContract.View {

    private val saveTaskButton by lazy { create_btn_save }
    private val createTaskEditText by lazy { create_et_task }


    private val taskCreatePresenter = TaskCreatePresenter(TaskRepository(), this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_task_create, container, false) ?: throw RuntimeException("Error inflating view")
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        saveTaskButton.setOnClickListener {
            val taskContent = createTaskEditText.text.toString()
            taskCreatePresenter.saveNote(taskContent)
        }
    }

    override fun showEmptyError() {
        Toast.makeText(activity, "Please fill the input", Toast.LENGTH_SHORT).show()
    }

    override fun showTaskList() {
        activity.finish()
    }

    companion object {
        fun newInstance() = TaskCreateFragment()
    }
}