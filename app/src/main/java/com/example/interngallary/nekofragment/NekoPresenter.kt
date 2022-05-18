package com.example.interngallary.nekofragment

import com.example.interngallary.api.NekoApi
import com.example.interngallary.api.QuestListResponse
import com.example.interngallary.base.mvp.BasePresenter
import com.example.interngallary.entity.AnimeEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class NekoPresenter @Inject constructor(var api: NekoApi) : BasePresenter<NekoView>() {

    override fun getAnime(): Single<QuestListResponse> = api.getQuestList(20)

}