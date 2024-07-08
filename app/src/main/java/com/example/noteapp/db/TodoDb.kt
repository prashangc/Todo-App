package com.example.noteapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.Todo

//@TypeConverters(CustomTypeConverter::class)
@Database(entities = [Todo::class], version = 1)
abstract class TodoDb : RoomDatabase() {

    companion object{
        const val NAME = "Todo_DB"
    }

    abstract fun getTodoDao() : TodoDao
}