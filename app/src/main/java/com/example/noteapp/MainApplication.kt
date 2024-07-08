package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.noteapp.db.TodoDb

class MainApplication: Application() {
    companion object {
        lateinit var todoDatabase : TodoDb
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDb::class.java,
            TodoDb.NAME,
        ).build()
    }
}