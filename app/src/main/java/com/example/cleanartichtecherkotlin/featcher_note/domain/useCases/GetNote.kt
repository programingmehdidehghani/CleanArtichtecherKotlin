package com.example.cleanartichtecherkotlin.featcher_note.domain.useCases

import android.provider.ContactsContract
import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory

class GetNote(
    private val repasitory: NoteRepasitory
) {

    suspend operator fun invoke(id : Int): Note? {
           return repasitory.getNoteById(id)
    }
}