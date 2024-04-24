package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ListItemBinding
class ToDoAdapter(private val list:MutableList<ItemDataModel>): RecyclerView.Adapter<ToDoAdapter.ListItemViewHolder>() {

    inner class ListItemViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            init{
                binding.delete.setOnClickListener{
                    list.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
            }
        fun bindItem(getItemList:ItemDataModel){
            binding.title.text =getItemList.title
            binding.description.text=getItemList.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

}