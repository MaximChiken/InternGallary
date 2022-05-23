package com.example.interngallary.base.mvp

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
abstract class BasePresenter<T : BaseView> : MvpPresenter<T>()