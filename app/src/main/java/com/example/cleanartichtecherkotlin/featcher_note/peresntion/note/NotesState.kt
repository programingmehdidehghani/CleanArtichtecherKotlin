package com.example.cleanartichtecherkotlin.featcher_note.peresntion.note

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.NoteOrder
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.OrderType

data class NotesState(
    val note: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Dsending),
    val isOrderSectionVisible : Boolean = false,

)
