package com.example.interngallary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MemeAdapter: RecyclerView.Adapter<MemeHolder>() {
    private val memeList = ArrayList<MemeRecyclerView>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return MemeHolder(view)
    }

    override fun onBindViewHolder(holder: MemeHolder, position: Int) {
        holder.bind(memeList[position])
    }

    override fun getItemCount(): Int {
        return memeList.size
    }

    fun addMeme(meme:MemeRecyclerView){
        memeList.add(meme)
        notifyDataSetChanged()
    }
}