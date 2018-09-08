package com.maplonki.todo.task_detail

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maplonki.todo.R

/**
 * Created by hugo on 9/6/18.
 */
class TaskDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_task_detail, container, false) ?: throw RuntimeException("Could not inflate view")
    }

    companion object {
        fun newInstance() = TaskDetailFragment()
    }
}
