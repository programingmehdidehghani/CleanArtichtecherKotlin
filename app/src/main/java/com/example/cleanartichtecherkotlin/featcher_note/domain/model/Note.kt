package com.example.cleanartichtecherkotlin.featcher_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity
data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color:Int,
    @PrimaryKey val id:Int? = null
){
    companion object{
    }
}

class InvalidNoteException(message:String):Exception(message)


