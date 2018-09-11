package com.yggdralisk.koinspotifysample.presentation.releases

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import kotlinx.android.synthetic.main.activity_releases.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReleasesActivity : AppCompatActivity() {
    private val viewModel by viewModel<ReleasesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_releases)
        observeViewModel()
        setupRecycler()
    }

    private fun setupRecycler() {
        releasesRecycler.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        viewModel.getNewReleases().observe({ this.lifecycle }, {
            handleReleases(it)
        })

        viewModel.getFetchErrorResId().observe({ this.lifecycle }, { resId ->
            resId?.let {
                showErrorView(getString(it))
            }
        })
    }

    private fun handleReleases(releases: List<ReleaseModel>) {
        if (releases.isEmpty()) {
            showEmptyView()
        } else {
            releasesRecycler.adapter = ReleasesRecyclerAdapter(releases)
            showReleasesRecycler()
        }
    }

    private fun showReleasesRecycler() {
        releasesRecycler.visibility = View.VISIBLE
        notFoundTextView.visibility = View.GONE
        errorTextView.visibility = View.GONE
    }

    private fun showEmptyView() {
        releasesRecycler.visibility = View.GONE
        notFoundTextView.visibility = View.VISIBLE
        errorTextView.visibility = View.GONE
    }

    private fun showErrorView(errorText: String) {
        errorTextView.visibility = View.VISIBLE
        notFoundTextView.visibility = View.GONE
        releasesRecycler.visibility = View.GONE
        errorTextView.text = errorText
    }
}
