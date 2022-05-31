package com.example.interngallary.nekofragment

import com.example.domain.AnimeGateway
import com.example.domain.QuestListResponse
import com.example.gateway.gateway.NekoGatewayImpl
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class NekoPresenter @Inject constructor(@Named("nekoGateway")var gatewayImpl: AnimeGateway) :
    BasePagingPresenter<NekoView>() {

    override fun getAnimePicture(): Single<QuestListResponse> = gatewayImpl.getAnime()

}