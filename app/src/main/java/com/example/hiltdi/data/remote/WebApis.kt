package com.example.hiltdi.data.remote

import com.example.hiltdi.model.DocumentModel
import retrofit2.Response
import retrofit2.http.GET

interface WebApis {

    @GET("todos/1")
    suspend fun getData(): Response<DocumentModel>

}