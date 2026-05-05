package com.mangesh.movieloading.di

import android.content.Context
import com.mangesh.movieloading.data.repository.local.TodoDao
import com.mangesh.movieloading.data.repository.local.TodoDatabase
import com.mangesh.movieloading.data.repository.local.TodoRepository
import com.mangesh.movieloading.data.repository.remote.TodoApiService
import com.mangesh.movieloading.domain.TodoFetchAndUpdateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideTodoApiService(): TodoApiService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase) = todoDatabase.todoDao()

    @Singleton
    @Provides
    fun provideTodoRepository(
        apiService: TodoApiService,
        todoDao: TodoDao
    ) = TodoRepository(apiService, todoDao)

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context) =
        TodoDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideTodoFetchAndUpdateUseCase(todoRepository: TodoRepository) =
        TodoFetchAndUpdateUseCase(todoRepository)
}