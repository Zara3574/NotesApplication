package com.myapps.notesapplication.ui.adapter

import com.myapps.notesapplication.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.myapps.notesapplication.databinding.NotesItemBinding
import com.myapps.notesapplication.model.Notes
import com.myapps.notesapplication.viewModel.notesViewModel
import kotlin.getValue

class NotesAdapter(context: Context, val list: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        val binding = NotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NotesViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.binding.showTitle.text = item.title.toString()
        holder.binding.showDescription.text = item.notes.toString()
        holder.binding.showDate.text = item.date.toString()
        when (item.priority.toString()) {
            "1" -> {
                holder.binding.priority.setBackgroundResource(R.drawable.green_circle)
            }

            "2" -> {
                holder.binding.priority.setBackgroundResource(R.drawable.yellow_circle)
            }

            "3" -> {
                holder.binding.priority.setBackgroundResource(R.drawable.red_circle)
            }
        }
//        holder.binding.root.setOnLongClickListener{
//
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class NotesViewHolder(val binding: NotesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}