package com.example.handlerandasynctaskandrxkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.handlerandasynctaskandrxkotlin.database.entity.NewsEntity
import com.example.handlerandasynctaskandrxkotlin.databinding.ItemNewBinding

class NewsAdapter : ListAdapter<NewsEntity, NewsAdapter.Vh>(MyDiffUtil()) {
    inner class Vh(val itemNewBinding: ItemNewBinding) :
        RecyclerView.ViewHolder(itemNewBinding.root) {

            fun onBind(newsEntity: NewsEntity){
                itemNewBinding.apply {
                    tv1.text = newsEntity.title
                    tv2.text = newsEntity.desctiption
                }
            }

    }

    class MyDiffUtil : DiffUtil.ItemCallback<NewsEntity>() {
        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        return holder.onBind(getItem(position ))
    }
}