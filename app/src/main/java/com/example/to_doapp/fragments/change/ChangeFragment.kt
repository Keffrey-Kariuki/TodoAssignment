package com.example.to_doapp.fragments.change

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.to_doapp.R
import com.example.to_doapp.databinding.FragmentChangeBinding
import com.example.to_doapp.drs.TodoDatabase
import com.example.to_doapp.fragments.list.TodoAdapter
import com.example.to_doapp.models.Todo

class ChangeFragment : Fragment() {

    private lateinit var binding : FragmentChangeBinding
    private lateinit var todoDB : TodoDatabase
    private lateinit var changeFragmentVM: ChangeFragmentVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChangeBinding.inflate(inflater, container, false)
        todoDB = TodoDatabase.getDatabase(requireContext())
        changeFragmentVM = ChangeFragmentVM(todoDB)

        val title = requireArguments().getString(TodoAdapter.TodoViewHolder.TITLE)
        val date = requireArguments().getString(TodoAdapter.TodoViewHolder.DATE)
        val desc = requireArguments().getString(TodoAdapter.TodoViewHolder.DESC)
        binding.etChangeTitle.setText(title)
        binding.etChangeDate.setText(date)
        binding.etChangeDescription.setText(desc)

        binding.btnUpdate.setOnClickListener {
            update()
            findNavController().navigate(R.id.action_changeFragment_to_listFragment)
        }

        binding.btnDelete.setOnClickListener {
            delete()
            findNavController().navigate(R.id.action_changeFragment_to_listFragment)
        }

        return binding.root
    }

    private fun update(){
        val updatedId = requireArguments().getLong(TodoAdapter.TodoViewHolder.ID)
        val updatedTitle = binding.etChangeTitle.text.toString()
        val updatedDate = binding.etChangeDate.text.toString()
        val updatedDesc = binding.etChangeDescription.text.toString()

        val updatedTodo = Todo(updatedId, updatedTitle, updatedDate, updatedDesc)
        changeFragmentVM.updateTodo(updatedTodo)
    }

    private fun delete(){
        val deletedId = requireArguments().getLong(TodoAdapter.TodoViewHolder.ID)
        val deletedTitle = binding.etChangeTitle.text.toString()
        val deletedDate = binding.etChangeDate.text.toString()
        val deletedDesc = binding.etChangeDescription.text.toString()

        val deletedTodo = Todo(deletedId, deletedTitle, deletedDate, deletedDesc)
        changeFragmentVM.deleteTodo(deletedTodo)
    }

}