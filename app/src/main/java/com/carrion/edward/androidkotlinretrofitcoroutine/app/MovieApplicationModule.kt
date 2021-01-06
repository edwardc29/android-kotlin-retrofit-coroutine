package com.carrion.edward.androidkotlinretrofitcoroutine.app

import android.content.Context
import android.net.ConnectivityManager
import com.carrion.edward.androidkotlinretrofitcoroutine.BuildConfig
import com.carrion.edward.androidkotlinretrofitcoroutine.data.api.ApiService
import com.carrion.edward.androidkotlinretrofitcoroutine.data.interceptor.ApiKeyInterceptor
import com.carrion.edward.androidkotlinretrofitcoroutine.data.interceptor.ConnectivityCheckingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MovieApplicationModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient.addInterceptor(httpLoggingInterceptor)
        okHttpClient.addInterceptor(ConnectivityCheckingInterceptor(context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
        okHttpClient.addInterceptor(ApiKeyInterceptor())

        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        return builder.client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}