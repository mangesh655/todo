package com.mangesh.movieloading.domain.model

import com.mangesh.movieloading.data.model.TodoEntity

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

fun TodoEntity.toDomainModel() : Todo {
        return Todo(
            userId = userId,
            id = id,
            title = title,
            completed = completed
        )
}