package com.example.hiltdi.model


import com.google.gson.annotations.SerializedName

data class DocumentModel(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)