package com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.API

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author hossam.
 */
object RetrofitProvider {
    private const val BASE_URL = "http://api.soundcloud.com/"
    private lateinit var soundCloudApi: SoundCloudApi

    init {
        val retrofit = initRetrofit()
        initServices(retrofit)
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun initServices(retrofit: Retrofit) {
        soundCloudApi = retrofit.create(SoundCloudApi::class.java)
    }

    fun loadUser() =
            soundCloudApi.getUser()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())!!

}