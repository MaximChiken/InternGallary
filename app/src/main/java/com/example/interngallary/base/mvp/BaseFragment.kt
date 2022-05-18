package com.example.interngallary.base.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.interngallary.base.BaseScrollListener
import com.example.interngallary.entity.AnimeEntity
import com.example.interngallary.rcView.AnimeAdapter
import moxy.MvpAppCompatFragment

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter<*>> : MvpAppCompatFragment() {

    abstract var presenter: P

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeAdapter
    private lateinit var viewFlipper: ViewFlipper

    abstract var toolBar: String

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    abstract fun initializeAdapterAndRecyclerView(): Pair<AnimeAdapter, RecyclerView>
    abstract fun initializeBinding(): VB
    abstract fun initializeViewFliper(): ViewFlipper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = initializeBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = toolBar
        viewFlipper = initializeViewFliper()
        initializeAdapterAndRecyclerView().also {
            recyclerView = it.second
            adapter = it.first
            recyclerView.adapter = adapter
        }
        setupListeners()
    }

    open fun setupListeners() {
        recyclerView.addOnScrollListener(object : BaseScrollListener(GridLayoutManager(context, 2)) {
            override fun loadMoreItems() {
                presenter.getPage()
                adapter.notifyDataSetChanged()
            }
        })
    }

    fun addAllPicture(picture: List<AnimeEntity>) {
        adapter.addAll(picture)
    }

    fun error() {
        viewFlipper.showNext()
    }
}