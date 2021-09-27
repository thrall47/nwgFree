package com.nwg.newworlduide


import android.content.ComponentCallbacks2
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity


class GuidesActivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    var muteBtn: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guides)

        backgroundMusic()
        passData()

        webView()

        backBtnToHome()

        dnwgClick()
        beginnerMenu()
        craftingMenu()
        expeditionMenu()
        loreMenu()
        pvpmodesMenu()
        weaponGuideMenu()


    }

    private fun weaponGuideMenu() {
        var dxMenu: Button = findViewById(R.id.weaponGuide)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.weaponsguide_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.bowG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-bow-guide")
                        }
                        R.id.fsG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-fire-staff-guide")
                        }
                        R.id.gag -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-great-axe-guide")
                        }
                        R.id.hatchetG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-hatchet-guide")
                        }
                        R.id.iegag -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-ice-gauntlet%20guide")
                        }
                        R.id.lesG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-life-staff-guide")
                        }
                        R.id.muskG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-musket-mastery-tree-guide")
                        }
                        R.id.repairG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-rapier-guide")
                        }
                        R.id.spearG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/everything-you-need-to-know-about-the-spear-in-new-world")
                        }
                        R.id.sasG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-sword-and-shield-guide")
                        }
                        R.id.whG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-war-hammer-guide")
                        }

                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun pvpmodesMenu() {
        var dxMenu: Button = findViewById(R.id.pvp)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.pvpmodes_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.duel -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/dueling-in-new-world")
                        }
                        R.id.owp -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/open-world-pvp-and-faction-control-points")
                        }
                        R.id.opr -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/outpost-rush")
                        }
                        R.id.sis -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-sieges")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun loreMenu() {
        var dxMenu: Button = findViewById(R.id.loreGuide)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.lore_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView2) as WebView
                var wbUrl = "https://newworldfans.com/guides"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.nwli -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-lore")
                        }
                        R.id.tas -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/The-ancients")
                        }
                        R.id.tcn -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/the-corruption")
                        }
                        R.id.tols -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/the-obelisks")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun expeditionMenu() {
        var dxMenu: Button = findViewById(R.id.expeditions)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.expedeition_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.axg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/amrine-excavation-expedition-guide")
                        }
                        R.id.dsy -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/dynasty-shipyard-expedition-guide")
                        }
                        R.id.ssb -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-starstone-barrows-expedition-guide")
                        }
                        R.id.tds -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-the-depths-expedition-guide")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun craftingMenu() {
        var dxMenu: Button = findViewById(R.id.crafting)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.crafting_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.arcanaGuide -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-arcana-guide")
                        }
                        R.id.cookingGuide -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-cooking-guide")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun beginnerMenu() {
        var dxMenu: Button = findViewById(R.id.beginner)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.guides_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.ubg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-ultimate-beginner-guide")
                        }
                        R.id.ag -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-armor-guide")
                        }
                        R.id.bss -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-storage-system")
                        }
                        R.id.campG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/how-to-build-a-camp-in-new-world")
                        }
                        R.id.cp -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/character-progression")
                        }
                        R.id.consumableG -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/Beginners-Guide-to-Consumables-in-New-World")
                        }
                        R.id.cbg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-corrupted-breach-guide")
                        }
                        R.id.elg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-leveling-tips")
                        }
                        R.id.fg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-faction-guide")
                        }
                        R.id.ftg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/how-to-fast-travel-in-new-world")
                        }
                        R.id.gg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/gathering-in-new-world")
                        }
                        R.id.hfg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/how-to-get-fiber-in-new-world")
                        }
                        R.id.hg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/new-world-housing")
                        }
                        R.id.srg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/how-to-salvage-gear-in-new-world")
                        }
                        R.id.tsg -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/everything-you-need-to-know-about-territories-&-settlements-in-new-world")
                        }
                        R.id.wst -> {
                            var wb = findViewById<View>(R.id.webView2) as WebView
                            wb.loadUrl("https://newworldfans.com/articles/beginners-guide-new-world-weapon-skill-trees")
                        }

                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun dnwgClick() {
        var dxMenu: Button = findViewById(R.id.dnwg)
        var wb = findViewById<View>(R.id.webView2) as WebView
        var wbUrl =
            "https://newworldfans.com/about-new-world-mmo"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun backBtnToHome() {
        var backBtnToHome: Button = findViewById(R.id.backBtnToHome)
        backBtnToHome.setOnClickListener { finish() }
    }

    private fun webView() {
        var wb = findViewById<View>(R.id.webView2) as WebView
        var wbUrl = "https://newworldfans.com/guides"
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
        myWebSettings.domStorageEnabled = true
        myWebSettings.useWideViewPort
        wb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                wb.loadUrl(url.toString())
                return true
            }

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
        mp = MediaPlayer.create(this@GuidesActivity, R.raw.soundtrack)
        mp?.start()
        mp?.setOnCompletionListener { mp?.start() }
    }

    override fun onPause() {
        finish()
        mp?.pause()
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