package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import android.app.Fragment
import com.letsgotoperfection.whatshotonsoundcloud.models.Track
import com.letsgotoperfection.whatshotonsoundcloud.ui.base.BaseContract

/**
 * @author hossam.
 */
class HotTracksListContract : BaseContract {

    interface View : BaseContract.View<Fragment> {
        fun showToast(msg: String)
        fun updateDate()
        fun updateInsertedData(itemCount: Int)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter : BaseContract.Presenter {
        fun getExistedTracks(): MutableList<Track>
        fun getTracksListSize(): Int
        fun onLoadMore()
        fun destroy()
    }
}