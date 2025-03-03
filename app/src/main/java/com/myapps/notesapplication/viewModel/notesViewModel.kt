package com.myapps.notesapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.myapps.notesapplication.database.NotesDatabase
import com.myapps.notesapplication.model.Notes
import com.myapps.notesapplication.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class notesViewModel(application: Application) : AndroidViewModel(application) {
    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDBInstance(application).getDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addNotes(notes)
        }
    }

    fun getNotes(): LiveData<List<Notes>> {
        return repository.getNotes()
    }

    fun updateNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateNotes(notes)
        }
    }

    fun deleteNotes(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteNotes(notes)
        }
    }
}