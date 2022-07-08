package com.example.cleanartichtecherkotlin.featcher_note.domain.useCases

import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.NoteOrder
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repasitory: NoteRepasitory
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Dsending)
    ):Flow<List<Note>>{
         return repasitory.getNotes().map { notes ->
             when(noteOrder.orderType){
                 is OrderType.Asending -> {
                     when(noteOrder){
                         is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                         is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                         is NoteOrder.Color -> notes.sortedBy { it.color }
                     }
                 }
                 is OrderType.Dsending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                 }
             }
         }
    }
}