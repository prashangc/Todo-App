package com.example.noteapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
//    val createdAt: Date
)

fun getFakeTodo(): List<Todo> {
    return listOf<Todo>(
        Todo(
            title = "Todo 1"
        ),
        Todo(
            title = "Todo 2"
        ),
        Todo(
            title = "Todo 3"
        ),
        Todo(
            title = "Todo 4"
        ),
    )
}
