package com.example.interngallary.kitsunefragment

import com.example.domain.AnimeGateway
import com.example.domain.QuestListResponse
import com.example.gateway.gateway.KitsuneGatewayImpl
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class KitsunePresenter @Inject constructor(@Named("kitsuneGateway")var gatewayImpl: AnimeGateway) :
    BasePagingPresenter<KitsuneView>() {

    override fun getAnimePicture(): Single<QuestListResponse> = gatewayImpl.getAnime()
}