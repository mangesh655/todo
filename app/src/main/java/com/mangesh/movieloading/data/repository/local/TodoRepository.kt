package com.mangesh.movieloading.data.repository.local

import android.util.Log
import com.mangesh.movieloading.data.mapper.toTodoEntity
import com.mangesh.movieloading.data.model.TodoEntity
import com.mangesh.movieloading.data.repository.remote.TodoApiService
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val apiService: TodoApiService,
    private val todoDao: TodoDao
) {

    suspend fun fetchTodosFromApi(): List<TodoEntity> {

        try {
            val response = apiService.getTodos()

            if (response.isSuccessful) {
                val todos = response.body()?.map { it.toTodoEntity() } ?: emptyList()
                if (todos.isNotEmpty()) {
                    Log.d("TodoRepository", "Fetched ${todos.size} todos from API")
                    insertTodos(todos)
                } else {
                    Log.d("TodoRepository", "No todos found in API response")
                    return emptyList()
                }
            } else {
                throw Exception("API Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("TodoRepository", "Error fetching todos: ${e.message}")
            return emptyList()
        }

        return todoDao.getTodos()
    }

    suspend fun insertTodos(todos: List<TodoEntity>) = todoDao.insertTodos(todos)

    suspend fun getTodosFromDb(): List<TodoEntity> {
        val localTodoList = todoDao.getTodos()
        return if (localTodoList.isNotEmpty()) {
            Log.d("TodoRepository", "Fetched ${localTodoList.size} todos from DB")
            localTodoList
        } else {
            fetchTodosFromApi()
        }
    }
}