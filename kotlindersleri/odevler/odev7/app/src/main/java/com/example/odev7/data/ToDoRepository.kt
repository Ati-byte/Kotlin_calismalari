package com.example.odev7.data

import com.example.odev7.model.ToDoModel
import com.example.odev7.data.ToDoDatabaseHelper


class ToDoRepository(private val db: ToDoDatabaseHelper) {

    fun getAll(): List<ToDoModel> = db.getAll()

    fun search(query: String): List<ToDoModel> = db.search(query)

    fun add(name: String) = db.add(name)

    fun delete(id: Int) = db.delete(id)

    fun update(id: Int, name: String) = db.update(id, name)
}
