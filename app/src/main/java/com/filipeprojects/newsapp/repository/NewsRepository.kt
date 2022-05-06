package com.filipeprojects.newsapp.repository

import com.filipeprojects.newsapp.api.RetrofitInstance
import com.filipeprojects.newsapp.db.ArticleDatabase
import com.filipeprojects.newsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
    RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.ArticleDao().upsert(article)

    fun getSavedNews() = db.ArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.ArticleDao().deleteArticle(article)
}