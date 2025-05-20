package com.example.odev7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.odev7.R
import com.example.odev7.databinding.FragmentDetailBinding
import com.example.todo.viewmodel.ToDoViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: ToDoViewModel
    private var todoId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ToDoViewModel::class.java]

        // Argümanı al
        todoId = arguments?.getInt("todoId") ?: 0

        // ID'ye göre veriyi bul ve göster
        val todo = viewModel.toDoList.value?.find { it.id == todoId }
        binding.editTextName.setText(todo?.name ?: "")

        // Güncelleme butonu
        binding.buttonUpdate.setOnClickListener {
            val updatedText = binding.editTextName.text.toString()
            viewModel.updateToDo(todoId, updatedText)
            findNavController().popBackStack()
        }

        // Silme butonu
        binding.buttonDelete.setOnClickListener {
            viewModel.deleteToDo(todoId)
            findNavController().popBackStack()
        }

        return binding.root
    }
}
