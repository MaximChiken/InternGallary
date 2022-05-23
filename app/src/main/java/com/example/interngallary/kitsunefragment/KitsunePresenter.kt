package com.example.interngallary.kitsunefragment

import com.example.interngallary.api.KitsuneApi
import com.example.interngallary.api.QuestListResponse
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class KitsunePresenter @Inject constructor(var api: KitsuneApi) : BasePagingPresenter<KitsuneView>() {

    override fun getAnime(): Single<QuestListResponse> = api.getQuestList(10)
}