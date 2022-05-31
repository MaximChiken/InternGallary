package com.example.interngallary.nekofragment

import com.example.gateway.api.NekoApi
import com.example.domain.QuestListResponse
import com.example.gateway.gateway.NekoGatewayImpl
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class NekoPresenter @Inject constructor(var gatewayImpl: NekoGatewayImpl) : BasePagingPresenter<NekoView>() {

    override fun getAnimePic(): Single<QuestListResponse> = gatewayImpl.getAnime()

}