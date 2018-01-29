package com.letsgotoperfection.whatshotonsoundcloud.models

/**
 * @author hossam.
 */

data class Track(
        val kind: String, //track
        val id: Int, //312469853
        val created_at: String, //2017/03/15 02:06:50 +0000
        val user_id: Int, //33917416
        val duration: Int, //5663850
        val commentable: Boolean, //true
        val state: String, //finished
        val original_content_size: Int, //226534837
        val last_modified: String, //2017/03/15 12:00:53 +0000
        val sharing: String, //public
        val tag_list: String, //Deep House "Chateau Flight" Vinyl
        val permalink: String, //winterschlafmangel
        val streamable: Boolean, //true
        val embeddable_by: String, //all
        val purchase_url: Any, //null
        val purchase_title: Any, //null
        val label_id: Any, //null
        val genre: String, //노래방
        val title: String, //Winterschlafmangel
        val description: String, //Schlaflosigkeit vong 1 Winter her
        val label_name: Any, //null
        val release: Any, //null
        val track_type: Any, //null
        val key_signature: Any, //null
        val isrc: Any, //null
        val video_url: Any, //null
        val bpm: Any, //null
        val release_year: Any, //null
        val release_month: Any, //null
        val release_day: Any, //null
        val original_format: String, //mp3
        val license: String, //all-rights-reserved
        val uri: String, //https://api.soundcloud.com/tracks/312469853
        val user: User,
        val permalink_url: String, //https://soundcloud.com/bongo_boris/winterschlafmangel
        val artwork_url: String, //https://i1.sndcdn.com/artworks-000212631890-enu6av-large.jpg
        val stream_url: String, //https://api.soundcloud.com/tracks/312469853/stream
        val download_url: String, //https://api.soundcloud.com/tracks/312469853/download
        val playback_count: Int, //327
        val download_count: Int, //0
        val favoritings_count: Int, //20
        val reposts_count: Int, //1
        val comment_count: Int, //2
        val downloadable: Boolean, //false
        val waveform_url: String, //https://w1.sndcdn.com/4yh0zONsGrMZ_m.png
        val attachments_uri: String //https://api.soundcloud.com/tracks/312469853/attachments
)

data class User(
        val id: Int, //33917416
        val kind: String, //user
        val permalink: String, //bongo_boris
        val username: String, //Beaurice
        val last_modified: String, //2018/01/26 17:51:20 +0000
        val uri: String, //https://api.soundcloud.com/users/33917416
        val permalink_url: String, //http://soundcloud.com/bongo_boris
        val avatar_url: String //https://i1.sndcdn.com/avatars-000242347696-6atcv5-large.jpg
)