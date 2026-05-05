package com.mangesh.movieloading.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mangesh.movieloading.domain.TodoFetchAndUpdateUseCase
import com.mangesh.movieloading.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListScreenViewModel @Inject constructor(
    private val todoFetchAndUpdateUseCase: TodoFetchAndUpdateUseCase
) : ViewModel() {

    private val _todos = MutableStateFlow(emptyList<Todo>())
    val todos : StateFlow<List<Todo>> = _todos

    init {
        fetchTodosFromLocal()
    }

    fun fetchTodosFromLocal() = viewModelScope.launch {
        todoFetchAndUpdateUseCase.getTodosFromLocal().let { fetchedTodos ->
            _todos.value = emptyList()
            _todos.value = fetchedTodos
        }
    }
}