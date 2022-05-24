package com.example.interngallary.rcView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interngallary.R
import com.example.interngallary.entity.AnimeEntity

class AnimeAdapter(private val callback: (AnimeEntity) -> Unit) : RecyclerView.Adapter<AnimeHolder>() {

    private val animeList = ArrayList<AnimeEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return AnimeHolder(view, callback)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }


    fun addAll(list: List<AnimeEntity>) {
        animeList.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        animeList.clear()
        notifyDataSetChanged()
    }
}