package com.letsgotoperfection.whatshotonsoundcloud.data.crawlers

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.API.RetrofitProvider
import com.letsgotoperfection.whatshotonsoundcloud.extentions.Rx2Bus
import com.letsgotoperfection.whatshotonsoundcloud.extentions.RxEvents
import com.letsgotoperfection.whatshotonsoundcloud.extentions.sortByTrendingTracks
import com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks.HotTracksModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
/**
 * @author hossam.
 */
class Crawler : JobService() {
    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("WhatsHotOnSoundCloud", "Successfully job has been executed.")
        return true
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        if (!Rx2Bus.hasObservers()) {
            return false
        }
        RetrofitProvider.loadFollowers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { followers ->
                            if (followers.collection.isNotEmpty()) {
                                followers.collection.forEach({ follower ->
                                    RetrofitProvider.loadTracks(follower.id)
                                            .subscribeOn(Schedulers.newThread())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe({ track ->
                                                HotTracksModel.tracks.addAll(track)
                                                val x = HotTracksModel.tracks.sortByTrendingTracks()
                                                HotTracksModel.tracks.clear()
                                                HotTracksModel.tracks.addAll(x)
                                            })
                                })
                                Rx2Bus.send(RxEvents.CrawlerEvents.DataUpdated)
                            }
                        },
                        { e ->
                            e.printStackTrace()
                        })
        return true
    }

}