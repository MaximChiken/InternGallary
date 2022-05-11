package com.example.interngallary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter: RecyclerView.Adapter<AnimeHolder>()  {
    private val animeList = ArrayList<AnimeEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return AnimeHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun addAnime(anime:AnimeEntity){
        animeList.add(anime)
        notifyDataSetChanged()
    }
}