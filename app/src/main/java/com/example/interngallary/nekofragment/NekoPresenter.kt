package com.example.interngallary.nekofragment

import com.example.interngallary.api.NekoApi
import com.example.interngallary.entity.AnimeEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class NekoPresenter @Inject constructor(private val questNekoApi: NekoApi) : MvpPresenter<NekoView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        questNekoApi.getQuestList(12)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val animeList = it.results.map { AnimeEntity(it.url) }
                viewState.addAllPicture(animeList)
            }, {
                viewState.error()
            }).let(compositeDisposable::add)
    }
}