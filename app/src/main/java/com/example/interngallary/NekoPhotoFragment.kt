package com.example.interngallary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.interngallary.api.NekoApi
import com.example.interngallary.databinding.FragmentNekoPhotoBinding
import com.example.interngallary.rcView.AnimeAdapter
import com.example.interngallary.rcView.AnimeEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class NekoPhotoFragment : Fragment() {

    private lateinit var binding: FragmentNekoPhotoBinding
    private val adapter = AnimeAdapter()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNekoPhotoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Neko"
        fetchQuestList((requireActivity() as? MainActivity)?.nekoQuestApi)
        //Сохраняет все перед уничтожением
        //Перенести вызов запроса в другой метод?
    }


    private fun fetchQuestList(questNekoApi: NekoApi?) {
        questNekoApi ?: return
        questNekoApi.getQuestList(12)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                with(binding) {
                    rcView.layoutManager = GridLayoutManager(context, 2)
                    rcView.adapter = adapter
                    it.results.forEachIndexed { _, value ->
                        val anime = AnimeEntity(value.url)
                        adapter.addAnime(anime)
                    }
                }
            }, {
                binding.viewFlipper.showNext()
            }).let(compositeDisposable::add)
    }
}


