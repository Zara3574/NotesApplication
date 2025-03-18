package com.myapps.notesapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.myapps.notesapplication.R
import com.myapps.notesapplication.databinding.FragmentHomeBinding
import com.myapps.notesapplication.ui.adapter.NotesAdapter
import com.myapps.notesapplication.viewModel.notesViewModel

class HomeFragment : Fragment() {
    val viewModel: notesViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel.getNotes().observe(viewLifecycleOwner) {notes->
            binding.recyclarView.layoutManager= GridLayoutManager(requireContext(),1)
            binding.recyclarView.adapter= NotesAdapter(requireContext(),notes){ note ->
                viewModel.deleteNotes(note) // Pass function reference correctly
            }
        }
        binding.addButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotes)
        }
        return binding.root
    }

}