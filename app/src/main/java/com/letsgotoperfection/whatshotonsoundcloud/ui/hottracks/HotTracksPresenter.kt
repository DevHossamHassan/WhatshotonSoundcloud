package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.API.RetrofitProvider
import com.letsgotoperfection.whatshotonsoundcloud.extentions.sortByTrendingTracks
import com.letsgotoperfection.whatshotonsoundcloud.models.Track
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author hossam.
 */
class HotTracksPresenter(private var hotTracksListView: HotTracksListContract.View) : HotTracksListContract.Presenter {

    override fun getExistedTracks(): MutableList<Track> {
        return HotTracksModel.tracks
    }

    override fun getTracksListSize(): Int {
        return HotTracksModel.tracks.size
    }

    override fun onLoadMore() {
        loadTracks()
    }

    private fun loadTracks() {
        hotTracksListView.showProgressBar()
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
                                                hotTracksListView.updateDate()
                                                hotTracksListView.hideProgressBar()
                                            })
                                })

                            }
                        },
                        { e ->
                            hotTracksListView.hideProgressBar()
                            hotTracksListView.showToast("Something went wrong! :" + e.message)
                        })
    }

    override fun destroy() {
        HotTracksModel.destroy()
    }
}