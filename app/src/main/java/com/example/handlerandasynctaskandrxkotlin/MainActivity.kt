package com.example.handlerandasynctaskandrxkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handlerandasynctaskandrxkotlin.adapter.NewsAdapter
import com.example.handlerandasynctaskandrxkotlin.database.AppDatabase
import com.example.handlerandasynctaskandrxkotlin.database.entity.NewsEntity
import com.example.handlerandasynctaskandrxkotlin.databinding.ActivityMainBinding
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var adapter: NewsAdapter
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)
        adapter = NewsAdapter()

        appDatabase.newsDao().getAllNews()
            .subscribeOn(Schedulers.io())
            .subscribe() {
                adapter.submitList(it)
            }



        binding.apply {
            rv.adapter = adapter
            saveBtn.setOnClickListener {
                val title = titleEt.text.toString()
                val deck = descEt.text.toString()
                val news = NewsEntity(title = title, desctiption = deck)
                appDatabase.newsDao().addNews(news)
            }
        }

    }
}