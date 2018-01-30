package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import RetrofitProvider
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
        if (HotTracksModel.tracks.isNotEmpty()) {
            hotTracksListView.updateDate()
            hotTracksListView.hideProgressBar()
            return
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
                                                if (follower.id == followers.collection.last().id) {
                                                    val x = HotTracksModel.tracks.sortByTrendingTracks()
                                                    HotTracksModel.tracks = x
                                                    hotTracksListView.updateDate()
                                                    hotTracksListView.hideProgressBar()
                                                }
                                            }, { e -> e.printStackTrace() })
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