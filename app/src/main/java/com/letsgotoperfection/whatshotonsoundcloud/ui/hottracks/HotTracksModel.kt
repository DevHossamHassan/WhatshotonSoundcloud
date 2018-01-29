package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import com.letsgotoperfection.whatshotonsoundcloud.models.Track

/**
 * @author hossam.
 */
object HotTracksModel {
    val tracks: MutableList<Track> = mutableListOf()
    fun destroy() {
        tracks.clear()
    }
}