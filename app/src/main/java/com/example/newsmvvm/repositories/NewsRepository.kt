package com.example.newsmvvm.repositories

import com.example.newsmvvm.data.db.ArticleDatabase
import com.example.newsmvvm.data.model.Article
import com.example.newsmvvm.data.network.RetrofitInstance

class NewsRepository(
    val db: ArticleDatabase
) {

    //API

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    //Room

    suspend fun upset(article: Article) = db.getArticleDao().upsert(article)

    suspend fun delete(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()


}