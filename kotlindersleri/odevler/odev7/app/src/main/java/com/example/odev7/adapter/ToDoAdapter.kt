package com.example.odev7.adapter

import com.example.odev7.model.ToDoModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7.databinding.ItemTodoBinding


class ToDoAdapter(private val onItemClick: (ToDoModel) -> Unit)
    : ListAdapter<ToDoModel, ToDoAdapter.ToDoViewHolder>(DIFF_CALLBACK) {

    inner class ToDoViewHolder(private val binding: ItemTodoBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: ToDoModel) {
            binding.textViewName.text = todo.name
            binding.root.setOnClickListener { onItemClick(todo) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ToDoModel>() {
            override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
