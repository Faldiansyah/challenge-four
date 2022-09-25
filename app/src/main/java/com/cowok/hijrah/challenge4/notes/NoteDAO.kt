package com.cowok.hijrah.challenge4.notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {
    @Insert
    fun insertNote(noteData: NoteData)

    @Query("SELECT * FROM NoteData ORDER BY id DESC")
    abstract fun getDataNote(): List<NoteData>?

    @Delete
    fun deleteNote(noteData: NoteData): Int

}