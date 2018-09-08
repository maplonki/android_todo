package com.maplonki.todo.task_create

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maplonki.todo.R

/**
 * Created by hugo on 9/6/18.
 */
class TaskCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
                .add(R.id.main_container, TaskCreateFragment.newInstance())
                .commit()
    }
}