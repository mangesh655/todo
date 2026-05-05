package com.mangesh.movieloading.data.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.mangesh.movieloading.data.model.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    suspend fun getTodos() : List<TodoEntity>

    @Upsert
    suspend fun insertTodo(todo: TodoEntity)

    @Upsert
    @Transaction
    suspend fun insertTodos(todo: List<TodoEntity>)

    @Update
    suspend fun updateTodo(todo: TodoEntity)
}