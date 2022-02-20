package com.kontick.sendypick_cleanarchitecture.presentation.start

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import com.kontick.sendypick_cleanarchitecture.R
import com.kontick.sendypick_cleanarchitecture.presentation.core.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

const val CURRENT_VERSION = 21

class StartScreenActivity : BaseActivity() {

    private val viewModel by viewModel<StartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        if (viewModel.isUpdateAvailable(CURRENT_VERSION)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.available_new_version)).setMessage(R.string.update_the_app)
            builder.setMessage(R.string.update_the_app)
            builder.setNeutralButton(R.string.update) { _, _ ->
                try {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                }
            }
            builder.setPositiveButton(getString(R.string.continue_s)) { _, _ ->
                makeAuth()
            }
            builder.create().show()
        } else makeAuth()
    }

    private fun makeAuth() {
        if (viewModel.isAuthorized()) switchToMain()
        else switchToAuth()
    }

}