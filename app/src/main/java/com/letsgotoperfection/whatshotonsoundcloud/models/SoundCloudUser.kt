package com.letsgotoperfection.whatshotonsoundcloud.models

/**
 * @author hossam.
 */
data class SoundCloudUser(
        val id: Int,
        val permalink: String?,
        val username: String,
        val uri: String,
        val permalinkUrl: String?,
        val avatarUrl: String?,
        val country: String?,
        val fullName: String?,
        val city: String,
        val description: String?,
        val discogsName: String?,
        val myspaceName: String?,
        val website: String?,
        val websiteTitle: String?,
        val online: Boolean,
        val trackCount: Int,
        val playlistCount: Int,
        val followersCount: Int,
        val followingsCount: Int,
        val publicFavoritesCount: Int
)

