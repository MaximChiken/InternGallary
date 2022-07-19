package com.example.interngallary.kitsunefragment

import androidx.navigation.fragment.findNavController
import com.example.interngallary.MyApp
import com.example.interngallary.base.mvp.paging_mvp.BasePagingFragment
import com.example.interngallary.databinding.FragmentPhotoBinding
import com.example.interngallary.rcView.AnimeAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class  KitsuneFragment : BasePagingFragment<FragmentPhotoBinding, KitsunePresenter>(), KitsuneView {

    @InjectPresenter
    override lateinit var presenter: KitsunePresenter

    @ProvidePresenter
    fun provideKitsunePresenter() = MyApp.appComponent.provideKitsunePresenter()

    override var toolBar: String = "Kitsune"


    override fun initializeBinding() = FragmentPhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = AnimeAdapter {
        val action = KitsuneFragmentDirections.actionKitsuneFragmentToDetailViewFragment(it.url)
        findNavController().navigate(action)

    } to binding.rcView

    override fun initializeViewFliper() = binding.viewFlipper

    override fun initializeSwipeRefreshLayout() = binding.swipeRefreshLayout

    override fun initializeProgressBar() = binding.progressBar

}





