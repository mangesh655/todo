package com.mangesh.movieloading.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mangesh.movieloading.ui.screens.TodoListDisplayScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListDisplayActivity : ComponentActivity() {

    private val todoListViewModel: TodoListScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val todoList by todoListViewModel.todos.collectAsState()
                TodoListDisplayScreen(todoList = todoList)
            }
        }
    }
}