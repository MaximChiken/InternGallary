package com.example.interngallary.detailview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.interngallary.MyApp
import com.example.interngallary.base.mvp.BaseFragment
import com.example.interngallary.databinding.DetailViewFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class DetailViewFragment : BaseFragment<DetailViewFragmentBinding>(), DetailViewView {

    private val args: DetailViewFragmentArgs by navArgs()

    @InjectPresenter
    lateinit var presenter: DetailViewPresenter

    @ProvidePresenter
    fun provideDetailViewPresenter() = MyApp.appComponent.provideDetailViewPresenter()

    override var toolBar: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = toolBar
        (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailUrl = args.url
        Glide.with(this).load(detailUrl).into(binding.imageView);

    }

    override fun initializeBinding() = DetailViewFragmentBinding.inflate(layoutInflater)
}