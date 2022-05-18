package com.example.interngallary.nekofragment

import com.example.interngallary.base.mvp.BaseView
import com.example.interngallary.entity.AnimeEntity
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


interface NekoView: BaseView