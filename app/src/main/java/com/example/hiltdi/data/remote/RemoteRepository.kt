package com.example.hiltdi.data.remote

import javax.inject.Inject

class RemoteRepository @Inject constructor(private val apiService: WebApis) {

    suspend fun getData() = apiService.getData()

}