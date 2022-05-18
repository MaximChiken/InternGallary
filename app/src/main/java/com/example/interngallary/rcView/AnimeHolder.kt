package com.example.interngallary.rcView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interngallary.databinding.AnimeItemBinding
import com.example.interngallary.entity.AnimeEntity


class AnimeHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = AnimeItemBinding.bind(view)


    fun bind(anime: AnimeEntity) {
        Glide.with(binding.root.context).load(anime.url).into(binding.imageView);
    }
}