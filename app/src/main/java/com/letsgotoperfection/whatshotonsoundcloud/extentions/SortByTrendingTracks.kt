package com.letsgotoperfection.whatshotonsoundcloud.extentions

import com.letsgotoperfection.whatshotonsoundcloud.models.Track

/**
 * @author hossam.
 */
fun MutableList<Track>.sortByTrendingTracks(): MutableList<Track> {
    return (this.distinctBy({ it.id }).sortedWith(
            compareBy({ it.playback_count }, { it.favoritings_count }, { it.reposts_count }, { it.created_at })))
            .reversed()
            .toMutableList()
}