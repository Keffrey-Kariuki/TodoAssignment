package com.example.to_doapp.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_doapp.R
import com.example.to_doapp.databinding.SingleTodoBinding
import com.example.to_doapp.models.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    private var todoList = emptyList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SingleTodoBinding.inflate(inflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todoList[position]
        holder.bindData(currentTodo)
        holder.row.setOnClickListener {
            holder.passTodo(currentTodo)
        }
    }

    override fun getItemCount(): Int = todoList.size

    class TodoViewHolder(private val binding : SingleTodoBinding) : RecyclerView.ViewHolder(binding.root){
        val row = binding.row

        fun bindData(todo : Todo){
            binding.tvTitle.text = todo.title
            binding.tvDate.text = todo.date
            binding.tvDescription.text = todo.description

            binding.executePendingBindings()
        }
        fun passTodo(currentTodo : Todo){
            val bundle = Bundle()
            bundle.putString(TITLE, currentTodo.title)
            bundle.putString(DATE, currentTodo.date)
            bundle.putString(DESC, currentTodo.description)
            bundle.putLong(ID, currentTodo.id)

            binding.root.findNavController().navigate(R.id.action_listFragment_to_changeFragment, bundle)
        }
        companion object{
            const val ID = "id"
            const val TITLE = "title"
            const val DATE = "date"
            const val DESC = "desc"
        }
    }

    fun setData(todo : List<Todo>){
        this.todoList = todo
        notifyDataSetChanged()
    }

}