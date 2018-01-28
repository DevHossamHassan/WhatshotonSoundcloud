package com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.API

import com.letsgotoperfection.whatshotonsoundcloud.BuildConfig
import com.letsgotoperfection.whatshotonsoundcloud.models.SoundCloudUser
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author hossam.
 */
interface SoundCloudApi {

    @GET("/users/3207?client_id=${BuildConfig.SOUNDCLOUD_CLIENT_ID}")
    fun getUser(): Single<SoundCloudUser>
}