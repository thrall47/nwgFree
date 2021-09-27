package com.nwg.newworlduide

import android.content.ComponentCallbacks2
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.webkit.CookieManager

class BuildsActivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    var muteBtn: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builds)

        backgroundMusic()
        passData()

        webView()

        backBtnToHome()

        reloadHome()

    }

    private fun reloadHome() {
        var dxMenu: Button = findViewById(R.id.reloadHome)
        var wb = findViewById<View>(R.id.webView3) as WebView
        var wbUrl =
            "https://newworldfans.com/builds"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun backBtnToHome() {
        var backBtnToHome: Button = findViewById(R.id.backBtnToHome)
        backBtnToHome.setOnClickListener { finish() }
    }

    private fun webView() {
        var wb = findViewById<View>(R.id.webView3) as WebView
        var wbUrl = "https://newworldfans.com/builds"
        var myWebSettings: WebSettings = wb.settings

        wb.settings.javaScriptEnabled = true
        wb.settings.loadWithOverviewMode = true
        wb.settings.pluginState = WebSettings.PluginState.ON
        wb.settings.loadsImagesAutomatically = true
        wb.settings.allowContentAccess = true
        wb.settings.allowFileAccess = true
        wb.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        wb.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        wb.settings.setAppCacheEnabled(true)
        CookieManager.setAcceptFileSchemeCookies(true)
        CookieManager.getInstance().setAcceptCookie(true)
        myWebSettings.domStorageEnabled = true
        myWebSettings.useWideViewPort
        wb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                wb.loadUrl(url.toString())
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                CookieManager.getInstance().getCookie(wbUrl)
                super.onPageFinished(view, url)
            }

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cookieManager = CookieManager.getInstance()
            cookieManager.setAcceptThirdPartyCookies(wb, true)
        }
        wb.settings.userAgentString = "Chrome/51.0.2704.90"
        wb.loadUrl(wbUrl)
    }

    private fun passData() {
        var get = intent.getBooleanExtra("mute", muteBtn);
        muteBtn = get
        val dbMute: ImageButton = findViewById(R.id.dbMute)

        //        if (id == R.id.item_refresh){
        //            loadNews()
        //        }
        if (muteBtn == true) {
            dbMute.setImageResource(R.drawable.mute_on)
            mp?.setVolume(0F, 0F)
            mp?.pause()
        }
        if (muteBtn == false) {
            dbMute.setImageResource(R.drawable.ic_baseline_music_off_24)
            mp?.setVolume(1F, 1F)
            mp?.start()
        }
        muteBtn = if (muteBtn == false) true else false
    }

    private fun backgroundMusic() {
        mp = MediaPlayer.create(this@BuildsActivity, R.raw.soundtrack)
        mp?.start()
        mp?.setOnCompletionListener { mp?.start() }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

//    override fun onBackPressed() {
//        var i = Intent(this, DrawerActivity::class.java)
//        startActivity(i)
//        super.onBackPressed()
//    }

    override fun onDestroy() {
        mp?.release()
        super.onDestroy()
    }

    override fun onTrimMemory(level: Int) {
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            if(mp != null){
                mp?.pause()
            }
        }
        super.onTrimMemory(level)
    }

    override fun onResume() {
        mp?.pause()
        mp?.start()
        super.onResume()
    }

    fun dbMute(view: View) {
        val dbMute: ImageButton = findViewById(R.id.dbMute)
        var id = view.id
        if (id == R.id.dbMute){
            if (muteBtn == true) {
                dbMute.setImageResource(R.drawable.mute_on)
                mp?.setVolume(0F, 0F)
                mp?.pause()
            }
            if (muteBtn == false) {
                dbMute.setImageResource(R.drawable.ic_baseline_music_off_24)
                mp?.setVolume(1F, 1F)
                mp?.start()
            }
            muteBtn = if (muteBtn == false) true else false
        }

    }


}