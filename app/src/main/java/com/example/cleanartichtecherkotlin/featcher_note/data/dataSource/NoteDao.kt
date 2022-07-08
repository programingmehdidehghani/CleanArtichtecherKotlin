package com.example.cleanartichtecherkotlin.featcher_note.data.dataSource

import androidx.room.*
import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id= :id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}