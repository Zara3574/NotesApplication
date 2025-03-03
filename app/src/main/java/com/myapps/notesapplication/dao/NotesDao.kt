package com.myapps.notesapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.myapps.notesapplication.model.Notes

@Dao
interface NotesDao {
    @Insert
    fun addNotes(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

    @Delete
    fun deleteNotes(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Notes>>
}