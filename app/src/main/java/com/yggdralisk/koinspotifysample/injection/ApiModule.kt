package com.yggdralisk.koinspotifysample.injection

import com.google.gson.Gson
import com.yggdralisk.koinspotifysample.BuildConfig
import com.yggdralisk.koinspotifysample.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val LOGGING_INTERCEPTOR = "LOGGING_INTERCEPTOR"

val apiModule = module {
    single { Gson() }
    single(LOGGING_INTERCEPTOR) {
        val logger = HttpLoggingInterceptor()

        logger.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        logger
    }
    single {
        OkHttpClient.Builder()
                .addInterceptor(get(LOGGING_INTERCEPTOR))
                .build()
    }
    single {
        Retrofit.Builder()
                .client(get())
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}

