package com.example.noteapp.db

import androidx.room.TypeConverters
import java.util.Date

class CustomTypeConverter {

    @TypeConverters
    fun fromDate(date: Date) : Long {
        return date.time
    }

    @TypeConverters
    fun toDate(time: Long) : Date {
        return Date(time)
    }
}