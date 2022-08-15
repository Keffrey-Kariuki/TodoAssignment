package com.example.to_doapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.to_doapp.drs.TodoDao
import com.example.to_doapp.drs.TodoDatabase
import com.example.to_doapp.models.Todo
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class TodoDatabaseTest {

    private lateinit var context : Context
    private lateinit var todoDB : TodoDatabase
    private lateinit var todoDao : TodoDao

    @Before
    fun createTest(){
        context = ApplicationProvider.getApplicationContext()
        todoDB = Room.inMemoryDatabaseBuilder(context, TodoDatabase::class.java).allowMainThreadQueries().build()
        todoDao = todoDB.todoDao()
    }

    @After
    @Throws(IOException::class)
    fun destroyTest(){
        todoDB.close()
    }


    @Test
    fun add(){
        val todo1 = Todo(0, "Hello", "1", "Say Hello")
        val todo2 = Todo(0, "Morning", "2", "Say Morning")
        val todo3 = Todo(0, "Bye", "1", "Say Bye")

        todoDao.addTestTodo(todo1,todo2, todo3)
        val testList = todoDao.getAll()
        assertEquals(3, testList.size)
    }

}