package com.example.interngallary.kitsunefragment

import com.example.interngallary.MyApp
import com.example.interngallary.base.mvp.BaseFragment
import com.example.interngallary.databinding.FragmentKitsunePhotoBinding
import com.example.interngallary.rcView.AnimeAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class KitsuneFragment : BaseFragment<FragmentKitsunePhotoBinding, KitsunePresenter>(), KitsuneView {

    @InjectPresenter
    override lateinit var presenter: KitsunePresenter

    @ProvidePresenter
    fun provideKitsunePresenter() = MyApp.appComponent.provideKitsunePresenter()

    override var toolBar: String = "Kitsune"

    override fun initializeBinding() = FragmentKitsunePhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = AnimeAdapter() to binding.rcView

    override fun initializeViewFliper() = binding.viewFlipper
}





