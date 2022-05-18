package com.example.interngallary.nekofragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.interngallary.MyApp
import com.example.interngallary.api.NekoApi
import com.example.interngallary.base.mvp.BaseFragment
import com.example.interngallary.databinding.FragmentNekoPhotoBinding
import com.example.interngallary.rcView.AnimeAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class NekoFragment : BaseFragment<FragmentNekoPhotoBinding, NekoPresenter>(), NekoView {

    @InjectPresenter
    override lateinit var presenter: NekoPresenter

    @ProvidePresenter
    fun provideNekoPresenter() = MyApp.appComponent.provideNekoPresenter()

    override var toolBar: String = "Neko"

    override fun initializeBinding()= FragmentNekoPhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = AnimeAdapter() to binding.rcView

    override fun initializeViewFliper() = binding.viewFlipper
}


