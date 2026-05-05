package com.mangesh.movieloading.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mangesh.movieloading.domain.model.Todo
import com.mangesh.movieloading.ui.components.TodoItem

@Composable
fun TodoListDisplayScreen(todoList: List<Todo>) {

    LazyColumn {
        items(todoList, key = { it.id }) { todo ->
            TodoItem(
                title = todo.title,
                isCompleted = todo.completed,
                modifier = Modifier
            )
        }
    }
}