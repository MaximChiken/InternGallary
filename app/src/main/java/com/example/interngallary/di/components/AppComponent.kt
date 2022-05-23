package com.example.interngallary.di.components

import com.example.interngallary.MyApp
import com.example.interngallary.detailview.DetailViewPresenter
import com.example.interngallary.di.module.AppModule
import com.example.interngallary.kitsunefragment.KitsunePresenter
import com.example.interngallary.nekofragment.NekoPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: MyApp)

    fun provideNekoPresenter(): NekoPresenter

    fun provideKitsunePresenter(): KitsunePresenter

    fun provideDetailViewPresenter(): DetailViewPresenter
}
