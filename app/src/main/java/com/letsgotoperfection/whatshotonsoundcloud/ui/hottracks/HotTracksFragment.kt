package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.letsgotoperfection.whatshotonsoundcloud.R
import com.letsgotoperfection.whatshotonsoundcloud.extentions.Rx2Bus
import com.letsgotoperfection.whatshotonsoundcloud.extentions.RxEvents
import com.letsgotoperfection.whatshotonsoundcloud.extentions.hide
import com.letsgotoperfection.whatshotonsoundcloud.extentions.show
import com.letsgotoperfection.whatshotonsoundcloud.ui.base.BaseFragment
import com.letsgotoperfection.whatshotonsoundcloud.ui.listeners.OnRecyclerViewScrollToTheEnd
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.hot_tracks_fragment.*
import java.util.concurrent.TimeUnit


/**
 * @author hossam.
 */
class HotTracksFragment : BaseFragment<HotTracksListContract.Presenter>(), HotTracksListContract.View {

    override val fragmentLayoutResourceId = R.layout.hot_tracks_fragment
    private lateinit var adapter: HotTracksListAdapter
    private lateinit var linLayManager: LinearLayoutManager

    override fun init(savedInstanceState: Bundle?) {
        presenter = HotTracksPresenter(this)
        val tapEventEmitter = Rx2Bus.toObservable().share()
        val debouncedEventEmitter = tapEventEmitter.debounce(1, TimeUnit.SECONDS)
        debouncedEventEmitter.observeOn(AndroidSchedulers.mainThread())
                .subscribe({ event ->
                    if (event == RxEvents.CrawlerEvents.DataUpdated) {
                        Log.d("WhatsHotOnSoundCloud", "Date Updated Please swipe down to refresh")
                        btnUpdateButton.show()
                    }
                })
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HotTracksListAdapter(presenter as HotTracksPresenter)
        hotTracksRecyclerView.setHasFixedSize(true)
        hotTracksRecyclerView.setItemViewCacheSize(20)
        hotTracksRecyclerView.isDrawingCacheEnabled = true
        hotTracksRecyclerView.itemAnimator = DefaultItemAnimator()
        linLayManager = LinearLayoutManager(activity.applicationContext)
        hotTracksRecyclerView.layoutManager = linLayManager
        hotTracksRecyclerView.adapter = adapter
        setRecyclerViewListeners()
        setOnUpdateButtonClickListener()
        if (savedInstanceState == null) {
            presenter.onLoadMore()
        }
    }

    private fun setRecyclerViewListeners() {
        hotTracksRecyclerView.addOnScrollListener(
                object : OnRecyclerViewScrollToTheEnd(linLayManager) {
                    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        if (linLayManager.findLastCompletelyVisibleItemPosition()
                                == adapter.itemCount - 1) {
//                            presenter.onLoadMore()
                        }
                    }
                })
        setSwipeRefreshListeners()
    }

    private fun setOnUpdateButtonClickListener() {
        btnUpdateButton.setOnClickListener {
            btnUpdateButton?.hide()
            updateDate()
        }
    }

    private fun setSwipeRefreshListeners() {
        hotTracksSwipeRefreshLayout.setOnRefreshListener({ presenter.onLoadMore() })
    }

    override fun showToast(msg: String) {
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        hotTracksSwipeRefreshLayout?.isRefreshing = true
    }

    override fun hideProgressBar() {
        hotTracksSwipeRefreshLayout?.isRefreshing = false
    }

    override fun updateDate() {
        adapter.notifyDataSetChanged()
    }

    override fun updateInsertedData(itemCount: Int) {
        adapter.notifyItemRangeInserted(presenter.getTracksListSize() - itemCount, itemCount)
    }
}