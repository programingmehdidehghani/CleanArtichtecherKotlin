package com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepasitory {

    fun getNotes():Flow<List<Note>>

    suspend fun getNoteById(id:Int):Note?

    suspend fun insertNotes(note: Note)

    suspend fun deleteNotes(note: Note)
}