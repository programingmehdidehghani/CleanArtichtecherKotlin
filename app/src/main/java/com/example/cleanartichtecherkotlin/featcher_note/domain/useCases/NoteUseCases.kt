package com.example.cleanartichtecherkotlin.featcher_note.domain.useCases

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNotes: DeleteNotes,
    val addNote: AddNote
)
