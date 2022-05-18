package com.example.interngallary.base.mvp

import com.example.interngallary.api.QuestListResponse
import com.example.interngallary.entity.AnimeEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
abstract class BasePresenter<T>: MvpPresenter<BaseView>() {

    private val compositeDisposable = CompositeDisposable()

    abstract fun getAnime(): Single<QuestListResponse>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getAnime()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val animeList = it.results.map { AnimeEntity(it.url) }
                viewState.addAllPicture(animeList)
            }, {
                viewState.error()
            }).let(compositeDisposable::add)
    }

    fun getPage(){
        getAnime()
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