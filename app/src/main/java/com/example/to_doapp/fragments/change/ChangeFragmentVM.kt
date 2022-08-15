package com.example.to_doapp.fragments.change

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.drs.TodoDatabase
import com.example.to_doapp.models.Todo
import kotlinx.coroutines.launch

class ChangeFragmentVM(private val todoDB : TodoDatabase) : ViewModel() {

    private val todoDao = todoDB.todoDao()

    fun updateTodo(todo : Todo){
        viewModelScope.launch {
            todoDao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo : Todo){
        viewModelScope.launch{
            todoDao.deleteTodo(todo)
        }
    }

}