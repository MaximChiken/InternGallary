package com.example.interngallary.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NekoApi {
    @GET("neko")
    fun getQuestList(@Query("amount")amount: Int): Single<QuestListResponse>
}