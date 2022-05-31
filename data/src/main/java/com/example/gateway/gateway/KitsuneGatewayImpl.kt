package com.example.gateway.gateway

import com.example.domain.AnimeGateway
import com.example.gateway.api.KitsuneApi
import com.example.domain.QuestListResponse
import io.reactivex.rxjava3.core.Single

class KitsuneGatewayImpl(private val kitsuneApi: KitsuneApi) : AnimeGateway {


    override fun getAnime(): Single<QuestListResponse> = kitsuneApi.getQuestList(10)

}