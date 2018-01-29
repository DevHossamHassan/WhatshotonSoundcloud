package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import com.letsgotoperfection.whatshotonsoundcloud.models.Track

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
//        hotTracksListView.showProgressBar()
//        RetrofitProvider.loadUser()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { it ->
//                            if (photosListModel.photoList.items == null) {
//                                photosListModel.photoList.items = it.items
//                                hotTracksListView.updateDate()
//
//                            } else {
//                                photosListModel.photoList.items?.addAll(it.items as MutableList<Photo>)
//                                hotTracksListView.updateInsertedData(it.items?.size ?: 0)
//                            }
//                            hotTracksListView.hideProgressBar()
//                        },
//                        { e ->
//                            hotTracksListView.hideProgressBar()
//                            hotTracksListView.showToast("Something went wrong! :" + e.message)
//                        })
    }

    override fun destroy() {
        HotTracksModel.destroy()
    }
}