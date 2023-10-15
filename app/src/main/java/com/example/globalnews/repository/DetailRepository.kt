package com.example.globalnews.repository

import com.example.globalnews.data.remote.ApiService

class DetailRepository(private val apiService: ApiService) {

    suspend fun getNoteById(id: String) = apiService.getNoteById(id)
}