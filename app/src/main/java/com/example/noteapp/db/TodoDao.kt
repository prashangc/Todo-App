package com.example.noteapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapp.Todo

@Dao
interface TodoDao {

    @Query("Select * from Todo")
    fun getTodos(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("Delete from Todo where id = :id")
    fun deleteTodo(id: Int)


}