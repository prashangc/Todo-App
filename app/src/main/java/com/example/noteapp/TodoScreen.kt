package com.example.noteapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoScreen(viewModel: TodoViewModel) {
    val listOfTodo by viewModel.todoList.observeAsState()
    var textValue by remember {
        mutableStateOf(value = "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
    ) {
        Row {
            OutlinedTextField(
                value = textValue,
                onValueChange = {
                    textValue = it
                },
                modifier = Modifier
                    .weight(2f)

            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    viewModel.addTodo(title = textValue)
                    textValue = ""
                },
                modifier = Modifier
                    .weight(1f)
            ) {
              Text(text = "Add")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        listOfTodo?.let {
            LazyColumn(
                content = {
                    items(it.count()) {
                            i -> TodoCard(
                                    todo = it[i],
                                    viewModel =  viewModel,
                            )
                    }
                },
            )
        }
    }
}

@Composable
fun TodoCard(todo: Todo, viewModel: TodoViewModel) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ){
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = todo.title,
            )
            IconButton(
                onClick = {
                    viewModel.delete(id = todo.id)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    tint = Color.Red,
                )
            }
        }
    }
}