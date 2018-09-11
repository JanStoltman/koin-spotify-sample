package com.yggdralisk.koinspotifysample.presentation.releases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import kotlinx.android.synthetic.main.releases_recycler_row.view.*

class ReleasesRecyclerAdapter(private val releases: List<ReleaseModel>) : RecyclerView.Adapter<ReleasesRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.releases_recycler_row, parent, false)
    )

    override fun getItemCount(): Int = releases.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(releases[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(release: ReleaseModel) {
            itemView.artistsTextView.text = release.artists.joinToString(", ") { a -> a.name }.trim()
            itemView.releaseNameTextView.text = release.name
            itemView.releaseDateTextView.text = release.release_date
        }
    }
}