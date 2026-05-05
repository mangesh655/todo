package com.mangesh.movieloading.data.repository.remote

import com.mangesh.movieloading.data.model.TodoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface TodoApiService {

    @GET("/todos")
    suspend fun getTodos() : Response<List<TodoDto>>

    @POST("/todos")
    suspend fun createTodo(@Body todo: TodoDto)

    @PUT("/posts/{id}")
    suspend fun updateTodo(@Query("id") id: Int, @Body todo: TodoDto)
}