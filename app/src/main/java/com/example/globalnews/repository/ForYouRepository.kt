package com.example.globalnews.repository

import com.example.globalnews.data.remote.ApiService
import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.USANews

class ForYouRepository(private val apiService:ApiService) {

    suspend fun getHeadlinesNews()=apiService.getHeadlinesNews()

    suspend fun getNotFromDB()=USANews()

}