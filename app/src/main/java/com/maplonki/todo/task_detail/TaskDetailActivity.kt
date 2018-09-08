package com.maplonki.todo.task_detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maplonki.todo.R
import com.maplonki.todo.task_create.TaskCreateFragment

/**
 * Created by hugo on 9/6/18.
 */
class TaskDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
                .add(R.id.main_container, TaskDetailFragment.newInstance())
                .commit()
    }
}