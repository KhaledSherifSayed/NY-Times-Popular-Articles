package com.ibtikar.mvvm_starter_koin_coroutines.data.network

import com.ibtikar.mvvm_starter_koin_coroutines.BuildConfig
import com.ibtikar.mvvm_starter_koin_coroutines.data.models.AllArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Meslmawy on 6/10/2021
 */

interface ApiService {
    @GET("v2/viewed/{period}.json?api-key=" + BuildConfig.API_KEY)
    suspend fun getAllArticles(@Path(value = "period") period: Int?=1): AllArticlesResponse
}