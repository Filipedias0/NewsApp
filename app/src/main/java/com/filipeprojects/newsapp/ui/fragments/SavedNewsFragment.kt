package com.filipeprojects.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.filipeprojects.newsapp.R
import com.filipeprojects.newsapp.db.ArticleDatabase
import com.filipeprojects.newsapp.repository.NewsRepository
import com.filipeprojects.newsapp.ui.NewsActivity
import com.filipeprojects.newsapp.ui.NewsViewModel
import com.filipeprojects.newsapp.ui.NewsViewModelProviderFactory

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {
    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsRepository = NewsRepository(ArticleDatabase(requireActivity()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider((requireActivity()), viewModelProviderFactory).get(NewsViewModel::class.java)
    }
}
