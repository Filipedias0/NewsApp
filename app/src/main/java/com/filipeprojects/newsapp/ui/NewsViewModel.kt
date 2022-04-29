package com.filipeprojects.newsapp.ui

import androidx.lifecycle.ViewModel
import com.filipeprojects.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel(){
}