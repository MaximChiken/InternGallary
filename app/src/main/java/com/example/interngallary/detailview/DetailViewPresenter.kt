package com.example.interngallary.detailview

import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class DetailViewPresenter @Inject constructor() : MvpPresenter<DetailViewView>()