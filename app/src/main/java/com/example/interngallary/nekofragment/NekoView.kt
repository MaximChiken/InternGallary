package com.example.interngallary.nekofragment

import com.example.interngallary.entity.AnimeEntity
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface NekoView: MvpView {

    fun addAllPicture(picture:List<AnimeEntity>)
    fun error()
}