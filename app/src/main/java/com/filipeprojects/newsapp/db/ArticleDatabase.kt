package com.filipeprojects.newsapp.db

import android.content.Context
import androidx.room.*
import com.filipeprojects.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun ArticleDao(): ArticleDao

    companion object {
        @Volatile private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            ArticleDatabase::class.java, "todo-list.db")
            .build()
    }
}
