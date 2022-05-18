package com.example.interngallary.base


import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs


abstract class BaseScrollListener(private var layoutManager: GridLayoutManager) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = layoutManager.itemCount
        val lastVisibleItemPosition =
            (recyclerView.layoutManager as LinearLayoutManager?)?.findLastVisibleItemPosition()
        if (totalItemCount - 4 <= (lastVisibleItemPosition ?: abs(totalItemCount - 4))) {
            loadMoreItems()
        }
    }

    protected abstract fun loadMoreItems()
}
