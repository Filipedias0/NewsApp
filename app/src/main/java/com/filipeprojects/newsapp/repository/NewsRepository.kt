package com.filipeprojects.newsapp.repository

import com.filipeprojects.newsapp.api.RetrofitInstance
import com.filipeprojects.newsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}