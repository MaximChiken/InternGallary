package com.example.interngallary.nekofragment

import androidx.navigation.fragment.findNavController
import com.example.interngallary.MyApp
import com.example.interngallary.base.mvp.paging_mvp.BasePagingFragment
import com.example.interngallary.databinding.FragmentPhotoBinding
import com.example.interngallary.rcView.AnimeAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class NekoFragment : BasePagingFragment<FragmentPhotoBinding, NekoPresenter>(), NekoView {

    @InjectPresenter
    override lateinit var presenter: NekoPresenter

    @ProvidePresenter
    fun provideNekoPresenter() = MyApp.appComponent.provideNekoPresenter()

    override var toolBar: String = "Neko"


    override fun initializeBinding() = FragmentPhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = AnimeAdapter {
        val action = NekoFragmentDirections.actionNekoFragmentToDetailViewFragment(it.url)
        findNavController().navigate(action)
    } to binding.rcView

    override fun initializeViewFliper() = binding.viewFlipper

    override fun initializeSwipeRefreshLayout() = binding.swipeRefreshLayout

    override fun initializeProgressBar() = binding.progressBar

    //override fun initializeNestedScroll() = binding.nestedScroll
}



