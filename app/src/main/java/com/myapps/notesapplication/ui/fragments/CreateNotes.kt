package com.myapps.notesapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.myapps.notesapplication.R
import com.myapps.notesapplication.databinding.FragmentCreateNotesBinding
import com.myapps.notesapplication.model.Notes
import com.myapps.notesapplication.viewModel.notesViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CreateNotes : Fragment() {
    lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel: notesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)
        binding.pGreen.setImageResource(R.drawable.done_icon)
        binding.pGreen.setOnClickListener {
            binding.pGreen.setImageResource(R.drawable.done_icon)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
            priority = "1"
        }
        binding.pYellow.setOnClickListener {
            binding.pYellow.setImageResource(R.drawable.done_icon)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
            priority = "2"
        }
        binding.pRed.setOnClickListener {
            binding.pRed.setImageResource(R.drawable.done_icon)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
            priority = "3"
        }
        binding.doneButton.setOnClickListener {
            createNotes(it)
        }
        return binding.root
    }

    fun createNotes(view: View) {
        val title = binding.title.text.toString()
        val subtitle = binding.subtitle.text.toString()
        val description = binding.description.text.toString()
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)
        Log.d("TAG", currentDate)
        viewModel.addNotes(Notes(0,title,subtitle,description,currentDate,priority))
        Log.d("","Data Saved SuccessFully")
        Toast.makeText(requireContext(), "Data Saved SuccessFully", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).navigate(R.id.action_createNotes_to_homeFragment)
    }
}