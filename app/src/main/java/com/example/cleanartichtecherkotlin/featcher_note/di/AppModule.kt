package com.example.cleanartichtecherkotlin.featcher_note.di

import android.app.Application
import androidx.room.Room
import com.example.cleanartichtecherkotlin.featcher_note.data.dataSource.NoteDatabase
import com.example.cleanartichtecherkotlin.featcher_note.data.repasitory.NoteRepasitoryImp
import com.example.cleanartichtecherkotlin.featcher_note.domain.repasitory.NoteRepasitory
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.AddNote
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.DeleteNotes
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.GetNotes
import com.example.cleanartichtecherkotlin.featcher_note.domain.useCases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDatabase{
          return Room.databaseBuilder(
              app,
              NoteDatabase::class.java,
              NoteDatabase.DATABASE_NAME
          ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepasitory(db : NoteDatabase):NoteRepasitory{
        return NoteRepasitoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repasitory: NoteRepasitory):NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repasitory),
            deleteNotes = DeleteNotes(repasitory),
            addNote = AddNote(repasitory)
        )
    }
}