package com.maplonki.todo.task_list

import android.os.Handler
import com.maplonki.todo.model.Task

/**
 * Created by hugo on 9/3/18.
 */
class TaskRepository {

    fun getTaskList(block: ((List<Task>) -> Unit)) {
        Handler().postDelayed({
            block(listOf(
                    Task(0, "Take out the trash", "today", 1),
                    Task(1, "Feed pets", "tomorrow", 2),
                    Task(2, "Go to school", "some day", 2),
                    Task(3, "Study for test", "eventually", 3)
            ))
        }, 1500)

    }
}