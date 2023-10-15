package com.example.globalnews.repository

import com.example.globalnews.data.remote.ApiService
import com.example.globalnews.model.ArticlesItem

class AddRepository (private val apiService: ApiService) {

    suspend fun addNote(note: ArticlesItem) = apiService.saveNote(note)
}