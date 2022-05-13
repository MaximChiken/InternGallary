package com.example.interngallary.nekofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.interngallary.MyApp
import com.example.interngallary.api.NekoApi
import com.example.interngallary.databinding.FragmentNekoPhotoBinding
import com.example.interngallary.entity.AnimeEntity
import com.example.interngallary.rcView.AnimeAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class NekoFragmentView : MvpAppCompatFragment(), NekoView {

    @InjectPresenter
    lateinit var nekoPresenter: NekoPresenter

    @ProvidePresenter
    fun provideNekoPresenter(): NekoPresenter{
        return MyApp.appComponent.provideNekoPresenter()
    }

    private lateinit var binding: FragmentNekoPhotoBinding
    private val adapter = AnimeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNekoPhotoBinding.inflate(layoutInflater)
        return with(binding) {
            rcView.layoutManager = GridLayoutManager(context, 2)
            rcView.adapter = adapter
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Neko"
    }

    override fun addAllPicture(picture: List<AnimeEntity>) {
        adapter.addAll(picture)
    }

    override fun error() {
        binding.viewFlipper.showNext()
    }

}


