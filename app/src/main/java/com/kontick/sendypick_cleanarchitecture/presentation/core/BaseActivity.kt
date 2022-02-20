package com.kontick.sendypick_cleanarchitecture.presentation.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.kontick.sendypick_cleanarchitecture.presentation.login.AuthActivity
import com.kontick.sendypick_cleanarchitecture.presentation.main.MainActivity

abstract class BaseActivity : AppCompatActivity() {

    fun switchToMain() = switchTo(MainActivity::class.java)
    fun switchToAuth() = switchTo(AuthActivity::class.java)

    private fun switchTo(clasz: Class<*>) {
        startActivity(Intent(this, clasz))
        finish()
    }

}