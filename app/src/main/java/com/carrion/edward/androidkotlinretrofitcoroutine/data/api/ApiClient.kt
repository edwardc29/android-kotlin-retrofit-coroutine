package com.carrion.edward.androidkotlinretrofitcoroutine.data.api

import com.carrion.edward.androidkotlinretrofitcoroutine.BuildConfig
import com.carrion.edward.androidkotlinretrofitcoroutine.data.interceptor.GeneralInterceptor
import com.carrion.edward.androidkotlinretrofitcoroutine.data.model.MovieResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {
    private var servicesApiInterface: ServicesApiInterface? = null

    fun build(): ServicesApiInterface? {
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())
        httpClient.addInterceptor(GeneralInterceptor())

        val retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
            ServicesApiInterface::class.java
        )

        return servicesApiInterface as ServicesApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    interface ServicesApiInterface {

        @GET(BuildConfig.MOVIES)
        suspend fun movies(@Query("page") page: Int): Response<MovieResult>
    }
}