package com.example.cleanartichtecherkotlin.featcher_note.domain.useCases

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory

class DeleteNotes(
    private val repasitory: NoteRepasitory
) {
    suspend operator fun invoke(note: Note){
        return repasitory.deleteNotes(note)
    }
}