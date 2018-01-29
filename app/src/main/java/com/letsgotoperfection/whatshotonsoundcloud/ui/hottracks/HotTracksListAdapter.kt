package com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.letsgotoperfection.whatshotonsoundcloud.R
import com.letsgotoperfection.whatshotonsoundcloud.extentions.loadUrl
import com.letsgotoperfection.whatshotonsoundcloud.models.Track
import com.letsgotoperfection.whatshotonsoundcloud.ui.listeners.OnRecyclerViewClickListener
import kotlinx.android.synthetic.main.hot_tracks_list_item.view.*

/**
 * @author hossam.
 */
class HotTracksListAdapter(private val presenter: HotTracksPresenter) : RecyclerView.Adapter<HotTracksListAdapter.HotTracksListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : HotTracksListHolder {

        return HotTracksListHolder((
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.hot_tracks_list_item, parent, false)),
                object : OnRecyclerViewClickListener {
                    override fun onRecyclerViewItemClicked(v: View, position: Int) {
                        //todo  implement on
                    }
                })

    }

    override fun onBindViewHolder(holder: HotTracksListHolder, position: Int) {
        val track: Track = presenter.getExistedTracks()[position]
        holder.itemView.tvTitle.text = track.title
        holder.itemView.tvPublishedAt.text = track.playback_count.toString()
        holder.itemView.imgView.loadUrl(track.artwork_url)
    }

    override fun getItemCount(): Int {
        return presenter.getTracksListSize()
    }

    class HotTracksListHolder(itemView: View,
                              private var onRecyclerViewClickListener: OnRecyclerViewClickListener)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(view: View) {
            onRecyclerViewClickListener.onRecyclerViewItemClicked(view, this.adapterPosition)
        }
    }
}
