package com.example.interngallary.kitsunefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.interngallary.MainActivity
import com.example.interngallary.api.KitsuneApi
import com.example.interngallary.databinding.FragmentKitsunePhotoBinding
import com.example.interngallary.entity.AnimeEntity
import com.example.interngallary.rcView.AnimeAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class KitsuneFragmentView : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    private val adapter = AnimeAdapter()
    private lateinit var binding: FragmentKitsunePhotoBinding
    private var images: List<AnimeEntity> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentKitsunePhotoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Kitsune"
        //fetchAnimeQuestList((requireActivity() as? MainActivity)?.kitsuneConfigureRetrofit())
        //Не сохраняет перед уничтожение
        //Перенести вызов запроса в другой метод?
        //Сохранять перед переключение фрагмента?
    }

    private fun fetchAnimeQuestList(kitsuneQuestApi: KitsuneApi?) {
        kitsuneQuestApi ?: return
        kitsuneQuestApi.getQuestList(12)
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


