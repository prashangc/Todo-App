package com.example.noteapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel(){
    private val todoDao = MainApplication.todoDatabase.getTodoDao()

    val todoList : LiveData<List<Todo>> = todoDao.getTodos()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String){
        /*
            i have done this inside view modal scope to prevent the UI thread from blocking
        */
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(
                Todo(
                    title = title,
//                    createdAt = Date.from(Instant.now()
                    )
                )
        }
    }

    fun delete(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }

}