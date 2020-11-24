package com.example.hiltdi.di

import com.example.hiltdi.data.remote.RemoteRepository
import com.example.hiltdi.data.remote.WebApis
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val API_BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): WebApis =
        retrofit.create(WebApis::class.java)

    @Singleton
    @Provides
    fun provideRemoteRepository(apiService: WebApis) = RemoteRepository(apiService)

}