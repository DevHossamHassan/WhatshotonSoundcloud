package com.letsgotoperfection.whatshotonsoundcloud.models

/**
 * @author hossam.
 */

data class FollowersResponse(
        val collection: List<Collection>,
        val next_href: String
)

data class Collection(
        val avatar_url: String, //https://i1.sndcdn.com/avatars-000242347696-6atcv5-large.jpg
        val id: Int, //33917416
        val kind: String, //user
        val permalink_url: String, //http://soundcloud.com/bongo_boris
        val uri: String, //https://api.soundcloud.com/users/33917416
        val username: String, //Beaurice
        val permalink: String, //bongo_boris
        val last_modified: String, //2018/01/26 17:51:20 +0000
        val first_name: String, //Aisnman
        val last_name: String,
        val full_name: String, //Aisnman
        val city: String, //Basel
        val description: String, //https://soundcloud.com/radio-l-ffelholz
        val country: Any, //null
        val track_count: Int, //1
        val public_favorites_count: Int, //0
        val followers_count: Int, //105
        val followings_count: Int, //380
        val plan: String, //Free
        val myspace_name: Any, //null
        val discogs_name: Any, //null
        val website_title: Any, //null
        val website: Any, //null
        val reposts_count: Int, //5
        val comments_count: Int, //108
        val online: Boolean, //false
        val likes_count: Int, //0
        val playlist_count: Int //1
)