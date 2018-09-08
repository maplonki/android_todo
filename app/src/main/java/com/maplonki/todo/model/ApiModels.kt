package com.maplonki.todo.model

/**
 * Created by hugo on 9/3/18.
 */
data class Task(
        var taskId: Long,
        var description: String,
        var date: String,
        var priority: Int,
        var completed: Boolean = false
)