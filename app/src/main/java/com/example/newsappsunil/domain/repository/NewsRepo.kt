package com.example.newsappsunil.domain.repository

import com.example.newsappsunil.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepo {

    suspend fun getNews(country: String, category: String, apiKey: String): Flow<Response<NewsResponse>>
}