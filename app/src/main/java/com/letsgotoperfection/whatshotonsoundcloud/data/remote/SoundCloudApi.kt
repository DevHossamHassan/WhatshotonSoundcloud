package com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.API

import com.letsgotoperfection.whatshotonsoundcloud.BuildConfig
import com.letsgotoperfection.whatshotonsoundcloud.models.FollowersResponse
import com.letsgotoperfection.whatshotonsoundcloud.models.SoundCloudUser
import com.letsgotoperfection.whatshotonsoundcloud.models.Track
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author hossam.
 */
interface SoundCloudApi {

    @GET("/users/${BuildConfig.USER_ID}?client_id=${BuildConfig.SOUNDCLOUD_CLIENT_ID}")
    fun getUser(): Single<SoundCloudUser>

    @GET("/users/${BuildConfig.USER_ID}/followers?client_id=${BuildConfig.SOUNDCLOUD_CLIENT_ID}&limit=20")
    fun getFollowers(): Single<FollowersResponse>

    @GET("/users/{userId}/favorites?client_id=${BuildConfig.SOUNDCLOUD_CLIENT_ID}&limit=20")
    fun getTracks(@Path("userId") userId: Int): Single<MutableList<Track>>

}