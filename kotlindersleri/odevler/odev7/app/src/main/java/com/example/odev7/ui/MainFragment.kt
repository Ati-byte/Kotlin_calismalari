package com.example.odev7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.odev7.R
import com.example.odev7.adapter.ToDoAdapter
import com.example.odev7.databinding.FragmentMainBinding
import com.example.todo.viewmodel.ToDoViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: ToDoViewModel
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ToDoViewModel::class.java]

        adapter = ToDoAdapter {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(it.id)
            findNavController().navigate(action)
        }

        binding.recyclerView.adapter = adapter
        viewModel.toDoList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

        viewModel.loadToDos()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?) = true
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchToDos(query ?: "")
                return true
            }
        })

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }

        return binding.root
    }
}
