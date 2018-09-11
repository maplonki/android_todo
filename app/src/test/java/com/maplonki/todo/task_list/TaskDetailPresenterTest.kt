package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task
import com.maplonki.todo.task_detail.TaskDetailContract
import com.maplonki.todo.task_detail.TaskDetailPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test

/**
 * Created by hugo on 9/11/18.
 */
class TaskDetailPresenterTest {

    private lateinit var detailPresenter: TaskDetailPresenter

    private val taskRepo: TaskRepository = mock()
    private val taskDetailView: TaskDetailContract.View = mock()

    @Before
    fun setupPresenterTest() {
        detailPresenter = TaskDetailPresenter(taskRepo, taskDetailView)
    }

    @Test
    fun shouldFailRetrieveDetail() {
        whenever(taskRepo.getTask(0)).thenReturn(Task(0, "", "", 1))
        whenever(taskRepo.getTask(-1)).thenReturn(null)

        detailPresenter.initViews(-1)
        verify(taskRepo).getTask(-1)

        verify(taskDetailView).showTaskNotFoundError()

        verifyNoMoreInteractions(taskRepo)
        verifyNoMoreInteractions(taskDetailView)
    }


    @Test
    fun shouldRetrieveDetailTask() {
        whenever(taskRepo.getTask(0)).thenReturn(Task(0, "hello", "today", 1))

        detailPresenter.initViews(0)

        verify(taskDetailView).showTaskDescription("hello")
        verify(taskDetailView).showTaskDate("today")
    }
}