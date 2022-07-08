package com.example.cleanartichtecherkotlin.featcher_note.data.repasitory

import androidx.compose.foundation.lazy.rememberLazyListState
import com.example.cleanartichtecherkotlin.featcher_note.data.dataSource.NoteDao
import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory
import kotlinx.coroutines.flow.Flow

class NoteRepasitoryImp (
    private val dao: NoteDao

): NoteRepasitory {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNotes(note: Note) {
        dao.inserNote(note)
    }

    override suspend fun deleteNotes(note: Note) {
        dao.deleteNote(note)
    }

}