package com.example.newsappsunil.data.repository

import com.example.newsappsunil.data.datasource.NewsDataSource
import com.example.newsappsunil.domain.repository.NewsRepo
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val dataSource: NewsDataSource
) :
    NewsRepo {

    override suspend fun getNews(country: String, category: String, apiKey: String) = flow {
        val response = dataSource.getNewsData(country, category, apiKey)
        if (response.isSuccessful) {
            emit(Response.success(response.body()))
        }
    }
}