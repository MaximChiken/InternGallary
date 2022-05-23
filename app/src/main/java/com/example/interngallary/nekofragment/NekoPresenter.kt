package com.example.interngallary.nekofragment

import com.example.interngallary.api.NekoApi
import com.example.interngallary.api.QuestListResponse
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class NekoPresenter @Inject constructor(var api: NekoApi) : BasePagingPresenter<NekoView>() {

    override fun getAnime(): Single<QuestListResponse> = api.getQuestList(10)

}