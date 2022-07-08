package com.example.cleanartichtecherkotlin.featcher_note.domain.useCases

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.InvalidNoteException
import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory
import kotlin.jvm.Throws

class AddNote(
    private val repasitory: NoteRepasitory
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
             throw InvalidNoteException("the of")
        }
        if (note.content.isBlank()){

        }
         repasitory.insertNotes(note)
    }
}