package com.example.to_doapp.fragments.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.drs.TodoDatabase
import com.example.to_doapp.models.Todo
import kotlinx.coroutines.launch

class AddFragmentVM(private val todoDB : TodoDatabase) : ViewModel() {

    private val todoDao = todoDB.todoDao()

    val title : MutableLiveData<String> = MutableLiveData("")
    val date : MutableLiveData<String> = MutableLiveData("")
    val description : MutableLiveData<String> = MutableLiveData("")


    fun addTodo(){
        val todo = Todo(0, title.value!!, date.value!!, description.value!!)
        viewModelScope.launch {
            todoDao.addTodo(todo)
        }

    }

}