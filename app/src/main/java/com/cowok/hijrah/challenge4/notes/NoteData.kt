package com.cowok.hijrah.challenge4.notes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var content: String
)