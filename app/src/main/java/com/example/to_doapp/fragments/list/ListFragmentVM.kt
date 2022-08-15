package com.example.to_doapp.fragments.list

import androidx.lifecycle.ViewModel
import com.example.to_doapp.drs.TodoDatabase

class ListFragmentVM(private val todoDB : TodoDatabase) : ViewModel() {

    private val todoDao = todoDB.todoDao()

    val todoList = todoDao.getAllTodos()

}