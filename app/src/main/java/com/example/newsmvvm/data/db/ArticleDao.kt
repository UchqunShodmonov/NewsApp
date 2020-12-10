package com.example.newsmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsmvvm.data.model.Article

@Dao
interface ArticleDao {

    // insert and update an article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long


    // get all articles
    @Query("select *from articles")
    fun getAllArticles(): LiveData<List<Article>>

    //delete an article
    @Delete
    suspend fun deleteArticle(article: Article)

}