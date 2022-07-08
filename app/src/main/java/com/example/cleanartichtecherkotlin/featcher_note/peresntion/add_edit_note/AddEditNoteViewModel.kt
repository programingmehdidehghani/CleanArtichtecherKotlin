package com.example.cleanartichtecherkotlin.featcher_note.peresntion.add_edit_note

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
     private val noteUseCases: NoteUseCases
):ViewModel(){

    private val _noteTitle = mutableListOf(NoteFiledTextState())
    val noteTitle : MutableList<NoteFiledTextState> = _noteTitle

    private val _noteContent = mutableListOf(NoteFiledTextState())
    val _noteContent : MutableList<NoteFiledTextState> = _noteContent

    private val _noteTitle = mutableListOf(NoteFiledTextState())
    val noteTitle : MutableList<NoteFiledTextState> = _noteTitle
}