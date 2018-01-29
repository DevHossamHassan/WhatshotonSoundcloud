package com.letsgotoperfection.whatshotonsoundcloud.extentions

import com.letsgotoperfection.whatshotonsoundcloud.models.Track

/**
 * @author hossam.
 */
fun MutableList<Track>.sortByTrendingTracks(): MutableList<Track> {
    return (this.distinct().sortedWith(
            compareBy({ it.playback_count }, { it.favoritings_count }, { it.reposts_count })))
            .reversed()
            .toMutableList()
}