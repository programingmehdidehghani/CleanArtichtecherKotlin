package com.example.cleanartichtecherkotlin.featcher_note.peresntion.note

import android.provider.ContactsContract
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanartichtecherkotlin.featcher_note.domain.model.Note
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.NoteUseCases
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.NoteOrder
import com.example.cleanartichtecherkotlin.featcher_note.domain.utils.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModels @Inject constructor(
      private val noteUseCases: NoteUseCases
): ViewModel() {

      private val _state = mutableStateOf(NotesState())
      val state : State<NotesState> = _state
      private var recentlyDeletedNote : Note? = null
      private var getNotesjob : Job ? = null

      init {
          getNotes(NoteOrder.Date(OrderType.Dsending))
      }

      fun onEvent(event: NotesEvent){
            when(event){
                  is NotesEvent.Order->{
                     if (state.value.noteOrder::class == event.noteOrder::class &&
                             state.value.noteOrder.orderType == event.noteOrder.orderType
                     ) {
                          return
                     }
                     getNotes(event.noteOrder)
                  }
                  is NotesEvent.DeleteNote ->{
                     viewModelScope.launch {
                           noteUseCases.deleteNotes(event.note)
                           recentlyDeletedNote = event.note
                     }
                  }
                  is NotesEvent.RestoreNote->{
                     viewModelScope.launch {
                           noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                           recentlyDeletedNote = null
                     }
                  }
                  is NotesEvent.ToggleOrderSection->{
                    _state.value = state.value.copy(
                          isOrderSectionVisible = !state.value.isOrderSectionVisible
                    )
                  }
            }
      }
      private fun getNotes(noteOrder: NoteOrder){
            getNotesjob?.cancel()
            getNotesjob =  noteUseCases.getNotes(noteOrder)
                   .onEach {notes->
                     _state.value = state.value.copy(
                           notes = notes,
                           noteOrder = noteOrder
                     )
                   }
                   .launchIn(viewModelScope)
      }
}