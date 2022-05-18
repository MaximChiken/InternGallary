package com.example.interngallary.base.mvp

import com.example.interngallary.entity.AnimeEntity
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView: MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun addAllPicture(picture:List<AnimeEntity>)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun error()
}