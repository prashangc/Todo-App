package com.example.noteapp

object TodoManager {
    val todoList = mutableListOf<Todo>()

    fun getAllTodo(): List<Todo> {
        return todoList
    }

    fun addTodo(todo: Todo) {
        todoList.add(Todo(
            title = "Todo 1",
            )
        )
    }

    fun deleteTodo(todo: Todo) {
        todoList.removeIf {
            it.id == todo.id
        }
    }
}