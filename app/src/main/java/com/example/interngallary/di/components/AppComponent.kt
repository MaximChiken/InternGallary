package com.example.interngallary.di.components

import android.content.Context
import com.example.interngallary.MyApp
import com.example.interngallary.detailview.DetailViewPresenter
import com.example.interngallary.di.module.ApiModule
import com.example.interngallary.di.module.AppModule
import com.example.interngallary.di.module.GatewayModule
import com.example.interngallary.di.module.RetrofitModule
import com.example.interngallary.kitsunefragment.KitsunePresenter
import com.example.interngallary.nekofragment.NekoPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ApiModule::class, GatewayModule::class])
interface AppComponent {

    fun inject(target: MyApp)

    fun provideNekoPresenter(): NekoPresenter

    fun provideKitsunePresenter(): KitsunePresenter

    fun provideDetailViewPresenter(): DetailViewPresenter

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: MyApp): Builder

        @BindsInstance
        fun context(context: Context): Builder
    }
}
