package com.example.interngallary

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interngallary.databinding.AnimeItemBinding


class MemeHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = AnimeItemBinding.bind(view)
    fun bind(meme: MemeRecyclerView){
        Glide.with(binding.root.context).load(meme.url).into(binding.imageView);
    }
}