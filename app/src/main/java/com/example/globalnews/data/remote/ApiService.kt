package com.example.globalnews.data.remote


import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.Business
import com.example.globalnews.model.Search
import com.example.globalnews.model.USANews
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines?country=us")
    fun getHeadlinesNews():Call<USANews>
//    suspend fun getBreakingNews(
//        @Query("country")
//        countryCode: String = "us",
//        @Query("page")
//        pageNumber: Int = 1,
//    ): Call<Headlines>
    @GET("everything?q=bitcoin&language=ru")
    fun getCategoryBusiness():Call<Business>

//    @GET("everything")
//    suspend fun searchForNews(
//        @Query("q")
//        searchQuery: String,
//        @Query("page")
//        pageNumber: Int = 1,
//        @Query("apiKey")
//        apiKey: String = API_KEY
//    ): Response<Headlines>

    @GET("everything?q=apple&language=ru&sortBy=popularity")
    fun getCategoryPopular():Call<USANews>
    @GET("top-headlines?/{id}")
    suspend fun getNoteById(@Path("id") id: String): Response<USANews>

    @GET("top-headlines?country=us&category=health")
    fun getCategoryHealth():Call<USANews>


    @GET("top-headlines?country=us&category=entertainment")
    fun getCategoryEntertainments():Call<USANews>

    @POST("top-headlines?country=us")
    suspend fun saveNote(@Body note: ArticlesItem): Response<USANews>

    @GET("top-headlines?country=us&category=sports")
    fun getCategorySport():Call<USANews>


    @GET("top-headlines?country=us&category=science")
    fun getCategorySciens():Call<USANews>


    @GET("everything")
    fun getCtegoryKorea(@Query("q")q:String):Call<Search>



}