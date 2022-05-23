package com.example.interngallary.base.mvp.paging_mvp

import com.example.interngallary.base.mvp.BaseView
import com.example.interngallary.entity.AnimeEntity
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BasePagingView : BaseView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun addAllPicture(picture: List<AnimeEntity>)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun clearList()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun isLoading(bool: Boolean)
}