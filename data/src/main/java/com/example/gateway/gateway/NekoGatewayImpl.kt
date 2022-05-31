package com.example.gateway.gateway

import com.example.domain.AnimeGateway
import com.example.gateway.api.NekoApi
import com.example.domain.QuestListResponse
import io.reactivex.rxjava3.core.Single

class NekoGatewayImpl(private val nekoApi: NekoApi) : AnimeGateway {


    override fun getAnime(): Single<QuestListResponse> = nekoApi.getQuestList(10)

}