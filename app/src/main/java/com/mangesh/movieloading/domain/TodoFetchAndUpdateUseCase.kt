package com.mangesh.movieloading.domain

import com.mangesh.movieloading.data.repository.local.TodoRepository
import com.mangesh.movieloading.domain.model.toDomainModel
import javax.inject.Inject

class TodoFetchAndUpdateUseCase @Inject constructor(private val todoRepository: TodoRepository) {

    suspend fun getTodosFromLocal() = todoRepository.getTodosFromDb().map { it.toDomainModel() }

    suspend fun getTodosFromApi() = todoRepository.fetchTodosFromApi().map { it.toDomainModel() }
}