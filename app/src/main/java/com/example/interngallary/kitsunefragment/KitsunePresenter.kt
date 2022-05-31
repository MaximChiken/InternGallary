package com.example.interngallary.kitsunefragment

import com.example.gateway.api.KitsuneApi
import com.example.domain.QuestListResponse
import com.example.gateway.gateway.KitsuneGatewayImpl
import com.example.gateway.gateway.NekoGatewayImpl
import com.example.interngallary.base.mvp.paging_mvp.BasePagingPresenter
import io.reactivex.rxjava3.core.Single
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class KitsunePresenter @Inject constructor(var gatewayImpl: KitsuneGatewayImpl) : BasePagingPresenter<KitsuneView>() {

    override fun getAnimePic(): Single<QuestListResponse> = gatewayImpl.getAnime()
}