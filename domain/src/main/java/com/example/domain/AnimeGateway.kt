package com.example.domain


import io.reactivex.rxjava3.core.Single

interface AnimeGateway {

    fun getAnime(): Single<QuestListResponse>

}