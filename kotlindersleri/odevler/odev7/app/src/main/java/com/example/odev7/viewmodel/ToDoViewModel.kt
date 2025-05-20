package com.example.todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.odev7.data.ToDoRepository
import com.example.odev7.model.ToDoModel
import com.example.odev7.data.ToDoDatabaseHelper


class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = ToDoRepository(ToDoDatabaseHelper(application))
    val toDoList = MutableLiveData<List<ToDoModel>>()

    fun loadToDos() {
        toDoList.value = repository.getAll()
    }

    fun searchToDos(query: String) {
        toDoList.value = repository.search(query)
    }

    fun addToDo(name: String) {
        repository.add(name)
        loadToDos()
    }

    fun deleteToDo(id: Int) {
        repository.delete(id)
        loadToDos()
    }

    fun updateToDo(id: Int, name: String) {
        repository.update(id, name)
        loadToDos()
    }
}
