package com.example.newsappsunil.di

import com.example.newsappsunil.data.repository.NewsRepoImpl
import com.example.newsappsunil.domain.repository.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsRepoModule {

    @Singleton
    @Binds
    abstract fun provideNewsRepo(repoImpl: NewsRepoImpl): NewsRepo

}