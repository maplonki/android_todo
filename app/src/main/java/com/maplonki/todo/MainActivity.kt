package com.maplonki.todo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.maplonki.todo.task_list.TaskListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction()
                .add(R.id.main_container, TaskListFragment.newInstance())
                .commit()
    }
}
