package com.example.to_doapp.drs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.to_doapp.models.Todo

@Dao
interface TodoDao {

    @Insert
    fun addTestTodo(vararg todo : Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo : Todo)

    @Query("SELECT * FROM todo_table")
    fun getAll() : List<Todo>

    @Query("SELECT * FROM todo_table")
    fun getAllTodos() : LiveData<List<Todo>>

    @Update
    suspend fun updateTodo(todo : Todo)

    @Delete
    suspend fun deleteTodo(todo : Todo)

}