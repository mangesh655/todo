package com.mangesh.movieloading.data.mapper

import com.mangesh.movieloading.data.model.TodoDto
import com.mangesh.movieloading.data.model.TodoEntity

fun TodoDto.toTodoEntity(): TodoEntity {
    return TodoEntity(
        userId = userId,
        id = id,
        title = title,
        completed = completed
    )
}

fun TodoEntity.toTodoDto(): TodoDto {
    return TodoDto(
        userId = userId,
        id = id,
        title = title,
        completed = completed
    )
}