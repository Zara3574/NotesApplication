package com.myapps.notesapplication.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title:String,
    val subtitle:String,
    val notes:String,
    val date: String,
    val priority: String
)
