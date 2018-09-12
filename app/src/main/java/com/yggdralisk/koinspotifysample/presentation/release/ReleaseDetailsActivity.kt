package com.yggdralisk.koinspotifysample.presentation.release

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yggdralisk.koinspotifysample.R
import com.yggdralisk.koinspotifysample.data.model.ReleaseModel
import kotlinx.android.synthetic.main.activity_release_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReleaseDetailsActivity : AppCompatActivity() {
    companion object {
        const val RELEASE_EXTRA = "RELEASE_EXTRA"
    }

    private val viewModel by viewModel<ReleaseDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_release_details)
        retrieveRelease()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getRelease().observe({ this.lifecycle }, {
            insertReleaseIntoLayout(it)
        })
    }

    private fun insertReleaseIntoLayout(release: ReleaseModel) {
        artistsTextView.text = release.artists.joinToString(", ") { a -> a.name }.trim()
        releaseNameTextView.text = release.name
        releaseDateTextView.text = release.release_date

        Glide.with(this)
                .load(release.images.firstOrNull()?.url)
                .into(releaseImage)
    }

    private fun retrieveRelease() {
        if (viewModel.getRelease().value == null && intent.hasExtra(RELEASE_EXTRA)) {
            viewModel.setRelease(intent.getParcelableExtra(RELEASE_EXTRA))
        }
    }
}