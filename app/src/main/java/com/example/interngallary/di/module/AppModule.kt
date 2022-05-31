package com.example.interngallary.di.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.interngallary.MyApp
import com.example.gateway.api.KitsuneApi
import com.example.gateway.api.NekoApi
import com.example.gateway.gateway.KitsuneGatewayImpl
import com.example.gateway.gateway.NekoGatewayImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule(private val app: MyApp) {

    @Provides
    @Singleton
    fun provideOkHttpClient(chuckerInterceptor: ChuckerInterceptor) = OkHttpClient.Builder()
        .addInterceptor(chuckerInterceptor)
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://nekos.best/api/v2/")
        .client((okHttpClient))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideChuker(context: Context) = ChuckerInterceptor.Builder(context).build()

    @Provides
    @Singleton
    fun provideNekoApi(retrofit: Retrofit) = retrofit.create(NekoApi::class.java)

    @Provides
    @Singleton
    fun provideKitsuneApi(retrofit: Retrofit) = retrofit.create(KitsuneApi::class.java)

    @Provides
    @Singleton
    fun provideNekoGateway(nekoApi: NekoApi) = NekoGatewayImpl(nekoApi)

    @Provides
    @Singleton
    fun provideKitsuneGateway(kitsuneApi: KitsuneApi) = KitsuneGatewayImpl(kitsuneApi)
}