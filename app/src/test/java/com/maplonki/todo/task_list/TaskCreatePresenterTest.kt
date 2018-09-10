package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task
import com.maplonki.todo.task_create.TaskCreateContract
import com.maplonki.todo.task_create.TaskCreatePresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.Before
import org.junit.Test

/**
 * Created by hugo on 9/10/18.
 */
class TaskCreatePresenterTest {

    private val taskRepo: TaskRepository = mock()
    private val taskCreateView: TaskCreateContract.View = mock()


    private lateinit var createPresenter: TaskCreatePresenter

    @Before
    fun setupPresenterTest() {
        createPresenter = TaskCreatePresenter(taskRepo, taskCreateView)
    }

    @Test
    fun shouldFailSaving() {
        createPresenter.saveNote("")

        verify(taskCreateView).showEmptyError()

        verifyNoMoreInteractions(taskRepo)
        verifyNoMoreInteractions(taskCreateView)

    }

    @Test
    fun shouldSaveTask() {
        createPresenter.saveNote("hello")

        val testTask = Task(0, "hello", "today", 1)
        verify(taskRepo).saveTask(testTask)
        verify(taskCreateView).showTaskList()
    }

}