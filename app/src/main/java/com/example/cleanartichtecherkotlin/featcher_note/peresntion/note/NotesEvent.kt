package com.example.cleanartichtecherkotlin.featcher_note.peresntion.note

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection:NotesEvent()

}
