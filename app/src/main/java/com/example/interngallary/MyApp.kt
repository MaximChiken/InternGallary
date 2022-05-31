package com.example.interngallary

import android.app.Application
import com.example.interngallary.di.components.AppComponent
import com.example.interngallary.di.components.DaggerAppComponent

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).context(applicationContext).build()
    }


    companion object {
        lateinit var appComponent: AppComponent
    }
}