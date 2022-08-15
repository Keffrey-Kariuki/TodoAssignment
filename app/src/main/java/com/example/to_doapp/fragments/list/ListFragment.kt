package com.example.to_doapp.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.to_doapp.R
import com.example.to_doapp.databinding.FragmentListBinding
import com.example.to_doapp.drs.TodoDatabase

class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding
    private lateinit var listFragmentVM: ListFragmentVM
    private lateinit var todoDB : TodoDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        todoDB = TodoDatabase.getDatabase(requireContext())
        listFragmentVM = ListFragmentVM(todoDB)

        binding.btnGoToAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        val adapter = TodoAdapter()
        binding.lifecycleOwner = viewLifecycleOwner
        listFragmentVM.todoList.observe(viewLifecycleOwner, Observer { todo -> adapter.setData(todo) })
        binding.rvListOfTodos.adapter = adapter

        return binding.root
    }

}