package com.example.odev7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.odev7.R
import com.example.odev7.databinding.FragmentAddBinding
import com.example.todo.viewmodel.ToDoViewModel


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: ToDoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ToDoViewModel::class.java]

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            if (name.isNotBlank()) {
                viewModel.addToDo(name)
                findNavController().popBackStack()
            }
        }

        return binding.root
    }
}
