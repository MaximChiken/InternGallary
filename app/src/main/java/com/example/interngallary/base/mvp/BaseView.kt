package com.example.interngallary.base.mvp

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView: MvpView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun error()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun success()
}