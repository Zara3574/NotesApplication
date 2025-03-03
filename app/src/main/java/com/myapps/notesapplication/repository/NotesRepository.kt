package com.myapps.notesapplication.repository

import androidx.lifecycle.LiveData
import com.myapps.notesapplication.dao.NotesDao
import com.myapps.notesapplication.model.Notes

class NotesRepository(val notesDao: NotesDao) {
    suspend fun addNotes(notes: Notes) {
        notesDao.addNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> {
        return notesDao.getNotes()
    }

    suspend fun updateNotes(notes: Notes) {
        notesDao.updateNotes(notes)
    }

    suspend fun deleteNotes(notes: Notes) {
        notesDao.deleteNotes(notes)
    }

}