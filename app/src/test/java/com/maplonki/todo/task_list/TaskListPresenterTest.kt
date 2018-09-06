package com.maplonki.todo.task_list

import com.maplonki.todo.model.Task
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

/**
 * Created by hugo on 9/3/18.
 */

class TaskListPresenterTest {

    private val repository: TaskRepository = mock()

    private val view: TaskListContract.View = mock()

    private lateinit var presenter: TaskListPresenter

    private val TEST_LIST = listOf(
            Task(0, "Take out the trash", "today", 1, true),
            Task(1, "Feed pets", "tomorrow", 2, false)
    )

    @Before
    fun setupPresenterTest() {
        //Setup mockito ann
        MockitoAnnotations.initMocks(this)
        presenter = TaskListPresenter(repository, view)
    }

    @Test
    fun shouldLoadTaskListInView() {
        whenever(repository.getTaskList()).thenReturn(TEST_LIST)

        presenter.loadTaskList()

        verify(view).showLoading(true)
        verify(repository).getTaskList()
        verify(view).showLoading(false)
        verify(view).showTaskList(TEST_LIST)

    }

    @Test
    fun shouldOpenNewTaskView() {
        presenter.openTaskNew()

        verify(view).showTaskNew()
    }

    @Test
    fun shouldOpenDetailTaskView() {
        presenter.openTaskDetail(0)

        verify(view).showTaskDetail(0)
    }


    @Test
    fun shouldFilterTaskList() {
        whenever(repository.getTaskList()).thenReturn(TEST_LIST)

        val filterResult = presenter.requestTaskList("completed")
        val filterList = listOf(Task(0, "Take out the trash", "today", 1, true))

        verify(repository).getTaskList()
        assertEquals(filterResult, filterList)
    }

    @Test
    fun shouldNotFilterTaskList() {
        whenever(repository.getTaskList()).thenReturn(TEST_LIST)

        val filterResult = presenter.requestTaskList("invalid_filter")

        verify(repository).getTaskList()
        assertEquals(filterResult, TEST_LIST)
    }

}
