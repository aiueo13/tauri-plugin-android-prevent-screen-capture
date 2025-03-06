package com.plugin.android_prevent_screen_capture

import android.webkit.WebView
import android.app.Activity
import android.content.Intent
import android.view.WindowManager
import app.tauri.annotation.TauriPlugin
import app.tauri.plugin.Plugin

@TauriPlugin
class PreventScreenCapture(private val activity: Activity): Plugin(activity) {

    override fun load(webView: WebView) {
        super.load(webView)
        disableScreenCapture()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        disableScreenCapture()
    }


    private fun disableScreenCapture() {
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
    }
}