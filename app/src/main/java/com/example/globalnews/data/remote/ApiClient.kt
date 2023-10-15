package com.example.globalnews.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val isTester=false
    private const val SERVER_PRODUCTION="https://newsapi.org/v2/"
    private const val SERVER_DEVELOPMENT="https://newsapi.org/v2/"
    private val baseURL=if (isTester) SERVER_DEVELOPMENT else SERVER_PRODUCTION
    private val client=getClient()


    private val retrofit=Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiService:ApiService= retrofit.create(ApiService::class.java)



    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader("X-Api-Key","f4dda5347f35435792a17fc95a0db0e2")
            chain.proceed(builder.build())
        }).build()
    }





}