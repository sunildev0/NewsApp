package com.example.newsappsunil.data.datasource

import com.example.newsappsunil.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsDataSource {

    @GET("v2/top-headlines")
    suspend fun getNewsData(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

}