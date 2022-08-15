package com.example.to_doapp.fragments.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.to_doapp.R
import com.example.to_doapp.databinding.FragmentAddBinding
import com.example.to_doapp.drs.TodoDatabase

class AddFragment : Fragment() {

    private lateinit var binding : FragmentAddBinding
    private lateinit var addFragmentVM: AddFragmentVM
    private lateinit var todoDB : TodoDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        todoDB = TodoDatabase.getDatabase(requireContext())
        addFragmentVM = AddFragmentVM(todoDB)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = addFragmentVM

        binding.btnAdd.setOnClickListener {
            addFragmentVM.addTodo()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
            binding.etTitle.text.clear()
            binding.etDate.text.clear()
            binding.etDescription.text.clear()
        }
    }

}