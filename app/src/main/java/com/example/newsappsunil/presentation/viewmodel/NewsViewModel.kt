package com.example.newsappsunil.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappsunil.data.model.NewsResponse
import com.example.newsappsunil.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val useCase: NewsUseCase) : ViewModel() {

    private val _getNewsResponse = MutableSharedFlow<Response<NewsResponse>>()
    val getNewsResponse = _getNewsResponse.asSharedFlow()

    fun getProductsDetails(country: String, category: String, apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getNewsData(country, category, apiKey).collect {
                withContext(Dispatchers.Main.immediate) {
                    if (it.isSuccessful) {
                        _getNewsResponse.emit(it)
                    }
                }
            }
        }
    }
}