package com.example.gateway.api

import com.example.domain.QuestListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface KitsuneApi {
    @GET("kitsune")
    fun getQuestList(@Query("amount") amount: Int): Single<QuestListResponse>
}
