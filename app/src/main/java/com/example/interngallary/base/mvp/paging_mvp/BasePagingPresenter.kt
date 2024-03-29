package com.example.interngallary.base.mvp.paging_mvp

import com.example.domain.QuestListResponse
import com.example.gateway.entity.AnimeEntity
import com.example.interngallary.base.mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
abstract class BasePagingPresenter<T : BasePagingView> : BasePresenter<T>() {

    private val compositeDisposable = CompositeDisposable()
    private val currentList: MutableList<AnimeEntity> = mutableListOf()
    var loading: Boolean = false


    abstract fun getAnimePicture(): Single<QuestListResponse>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getAnimePicture()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.success()
                val animeList = it.results.map { AnimeEntity(it.url) }
                currentList.addAll(animeList)
                viewState.addAllPicture(currentList)
            }, {
                viewState.error()
            }).let(compositeDisposable::add)
    }

    fun getPage() {
        if (!loading) {
            getAnimePicture()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    loading = true
                    viewState.isLoading(true)
                }
                .doFinally {
                    viewState.isLoading(false)
                    loading = false
                }
                .subscribe({
                    viewState.success()
                    val animeList = it.results.map { AnimeEntity(it.url) }
                    currentList.addAll(animeList)
                    viewState.addAllPicture(currentList)
                }, {
                    viewState.error()
                }).let(compositeDisposable::add)
        }
    }

    fun swipeRefresh() {
        viewState.clearList()
        currentList.clear()
        getPage()
    }

    fun getChosenItem(itemPosition: Int): String = currentList[itemPosition].url
}
