package com.example.interngallary.di.module

import com.example.domain.AnimeGateway
import com.example.gateway.api.KitsuneApi
import com.example.gateway.api.NekoApi
import com.example.gateway.gateway.KitsuneGatewayImpl
import com.example.gateway.gateway.NekoGatewayImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class GatewayModule {

    @Provides
    @Singleton
    @Named("nekoGateway")
    fun provideNekoGateway(nekoApi: NekoApi): AnimeGateway = NekoGatewayImpl(nekoApi)

    @Provides
    @Singleton
    @Named("kitsuneGateway")
    fun provideKitsuneGateway(kitsuneApi: KitsuneApi): AnimeGateway = KitsuneGatewayImpl(kitsuneApi)
}