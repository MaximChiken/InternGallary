package com.example.interngallary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.interngallary.api.KitsuneApi
import com.example.interngallary.api.NekoApi
import com.example.interngallary.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://nekos.best/api/v2/")
        .client((okHttpClient))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            setSupportActionBar(appToolbar)
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHost
            bottomNavigationView.setupWithNavController(navHostFragment.navController)
        }
    }

    fun nekoConfigureRetrofit() = retrofit.create(NekoApi::class.java)
    fun kitsuneConfigureRetrofit() = retrofit.create(KitsuneApi::class.java)
}