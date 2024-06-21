package com.example.newsappsunil.domain.usecase

import com.example.newsappsunil.domain.repository.NewsRepo
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repo: NewsRepo) {

    suspend fun getNewsData(country: String, category: String, apiKey: String) =
        repo.getNews(country, category, apiKey)

}