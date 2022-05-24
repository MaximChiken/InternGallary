package com.example.interngallary.base.mvp.paging_mvp

import android.os.Bundle
import android.view.View
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewbinding.ViewBinding
import com.agrawalsuneet.dotsloader.loaders.LinearDotsLoader
import com.example.interngallary.base.mvp.BaseFragment
import com.example.interngallary.entity.AnimeEntity
import com.example.interngallary.rcView.AnimeAdapter
import java.lang.StrictMath.abs

abstract class BasePagingFragment<VB : ViewBinding, P : BasePagingPresenter<*>> : BaseFragment<VB>(),
    BasePagingView {


    abstract var presenter: P

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeAdapter
    private lateinit var viewFlipper: ViewFlipper
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: LinearDotsLoader
    //private lateinit var nestedScroll: NestedScrollView

    abstract fun initializeAdapterAndRecyclerView(): Pair<AnimeAdapter, RecyclerView>
    abstract fun initializeViewFliper(): ViewFlipper
    abstract fun initializeSwipeRefreshLayout(): SwipeRefreshLayout
    abstract fun initializeProgressBar(): LinearDotsLoader
    //abstract fun initializeNestedScroll(): NestedScrollView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = toolBar
        (activity as? AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        progressBar = initializeProgressBar()
        viewFlipper = initializeViewFliper()
        //nestedScroll = initializeNestedScroll()
        swipeRefreshLayout = initializeSwipeRefreshLayout()
        initializeAdapterAndRecyclerView().also {
            recyclerView = it.second
            adapter = it.first
            recyclerView.adapter = adapter
        }
        setUpListeners()
    }

    open fun setUpListeners() {

        /*nestedScroll.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight){
                presenter.getPage()
        }
        })*/
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = adapter.itemCount
                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)?.findLastVisibleItemPosition()
                if (totalItemCount - 4 <= (lastVisibleItemPosition ?: abs(totalItemCount - 4))) {
                    presenter.getPage()
                }
            }
        })

        swipeRefreshLayout.setOnRefreshListener {
            presenter.swipeRefresh()
            swipeRefreshLayout.isRefreshing = false
        }
    }


    override fun isLoading(bool: Boolean) {
        if (bool) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }

    }

    override fun clearList() = adapter.clear()

    override fun addAllPicture(picture: List<AnimeEntity>) = adapter.addAll(picture)

    override fun success() {
        viewFlipper.displayedChild = 2
    }

    override fun error() {
        viewFlipper.displayedChild = 1
    }

}