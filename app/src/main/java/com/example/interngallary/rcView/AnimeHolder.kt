package com.example.interngallary.rcView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interngallary.databinding.AnimeItemBinding
import com.example.interngallary.entity.AnimeEntity


class AnimeHolder(view: View, private val callback: (AnimeEntity) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = AnimeItemBinding.bind(view)


    fun bind(anime: AnimeEntity) = with(binding) {
        Glide.with(root.context).load(anime.url).into(imageView)
        binding.root.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                callback.invoke(anime)
            }
        }
    }
}