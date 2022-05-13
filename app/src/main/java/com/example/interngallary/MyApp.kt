package com.example.interngallary

import android.app.Application
import com.example.interngallary.di.components.AppComponent
import com.example.interngallary.di.components.DaggerAppComponent
import com.example.interngallary.di.module.AppModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}