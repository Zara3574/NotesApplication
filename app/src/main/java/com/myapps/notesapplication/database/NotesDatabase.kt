package com.myapps.notesapplication.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Database
import com.myapps.notesapplication.dao.NotesDao
import com.myapps.notesapplication.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun getDao(): NotesDao

    companion object {
        @Volatile
        private var instance: NotesDatabase? = null
        fun getDBInstance(context: Context): NotesDatabase {
            val tempIns = instance
            if (tempIns == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, NotesDatabase::class.java, "notesDb").build()
                }
            }
            return instance!!
        }
    }
}

