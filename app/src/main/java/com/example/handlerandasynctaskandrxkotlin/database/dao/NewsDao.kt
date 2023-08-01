package com.example.handlerandasynctaskandrxkotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.handlerandasynctaskandrxkotlin.database.entity.NewsEntity
import io.reactivex.rxjava3.core.Flowable

@Dao
interface NewsDao {

    @Insert
    fun addNews(newsEntity: NewsEntity)

    @Query("select * from newsentity")
    fun getAllNews():Flowable<List<NewsEntity>>

}