package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todoapp.databinding.FragmentFirstPageBinding
class FirstPageFragment : Fragment() {


    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstPageBinding.inflate(inflater,container,false)
        val itemList = mutableListOf<ItemDataModel>()



        binding.button2.setOnClickListener{
            val title = binding.text1.text.toString()
            val desc = binding.Text2.text.toString()


            if(title.isEmpty() || desc.isEmpty()){
                Toast.makeText(requireContext(), "Fill all the blanks", Toast.LENGTH_SHORT).show()
            }
            else{

                val newItem = ItemDataModel(title,desc)
                itemList.add(newItem)

                myAdapter = ToDoAdapter(itemList)
                binding.recyclerview.adapter = myAdapter
            }

            binding.text1.text.clear()
            binding.Text2.text.clear()
        }
        return binding.root
    }
}