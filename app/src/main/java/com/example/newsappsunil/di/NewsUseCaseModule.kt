package com.example.newsappsunil.di

import com.example.newsappsunil.domain.repository.NewsRepo
import com.example.newsappsunil.domain.usecase.NewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NewsUseCaseModule {

    @Provides
    fun provideNewsUseCase(repo: NewsRepo) = NewsUseCase(repo)

}