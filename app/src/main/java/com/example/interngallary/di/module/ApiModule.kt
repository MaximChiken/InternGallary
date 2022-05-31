package com.example.interngallary.di.module

import com.example.gateway.api.KitsuneApi
import com.example.gateway.api.NekoApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideNekoApi(retrofit: Retrofit) = retrofit.create(NekoApi::class.java)

    @Provides
    @Singleton
    fun provideKitsuneApi(retrofit: Retrofit) = retrofit.create(KitsuneApi::class.java)
}