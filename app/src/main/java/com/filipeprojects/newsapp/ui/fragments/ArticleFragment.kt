package com.filipeprojects.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.filipeprojects.newsapp.R
import com.filipeprojects.newsapp.db.ArticleDatabase
import com.filipeprojects.newsapp.repository.NewsRepository
import com.filipeprojects.newsapp.ui.NewsActivity
import com.filipeprojects.newsapp.ui.NewsViewModel
import com.filipeprojects.newsapp.ui.NewsViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsRepository = NewsRepository(ArticleDatabase(requireActivity()))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider((requireActivity()), viewModelProviderFactory).get(NewsViewModel::class.java)

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener(){
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved succesfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}