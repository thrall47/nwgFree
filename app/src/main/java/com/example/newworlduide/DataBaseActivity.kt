package com.nwg.newworlduide

import android.content.ComponentCallbacks2
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import com.google.android.gms.ads.*

class DataBaseActivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    var muteBtn: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)






        backgroundMusic()
        passData()
        webView()

        backBtnToHome()

        itemsMenu()
        recipesMenu()
        furnitureMenu()
        gemsMenu()
        perksMenu()
        achievementClick()
        creaturesClick()
        dyeClick()
        gatherableClick()
        lootClick()
        loreMenu()
        questsClick()
        npcClick()



    }

    private fun npcClick() {
        var dxMenu: Button = findViewById(R.id.NPCs)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/NPCs?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun questsClick() {
        var dxMenu: Button = findViewById(R.id.Quests)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Quests?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun loreMenu() {
        var dxMenu: Button = findViewById(R.id.Lore)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Lore?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun lootClick() {
        var dxMenu: Button = findViewById(R.id.LootContainers)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/LootContainers?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun gatherableClick() {
        var dxMenu: Button = findViewById(R.id.Gatherable)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Gatherables?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun dyeClick() {
        var dxMenu: Button = findViewById(R.id.Dye)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Dye?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun creaturesClick() {
        var dxMenu: Button = findViewById(R.id.Creatures)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Creatures?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun achievementClick() {
        var dxMenu: Button = findViewById(R.id.Achievements)
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl =
            "https://newworldfans.com/db/category/Achievements?page=1&attributes=&perks=&sort=name&dir=asc"
        dxMenu.setOnClickListener {
            wb.loadUrl(wbUrl)
        }
    }

    private fun perksMenu() {
        var dxMenu: Button = findViewById(R.id.Perks)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.perks_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView) as WebView
                var wbUrl = "https://newworldfans.com/db"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.all -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/All?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.ArmorP -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Armor?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.WeaponP -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Weapon?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.JewelryP -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Jewelry?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Amulet -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Amulet?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Earring -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Earring?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Ring -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Ring?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Bag -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Bag?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Tool -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Tool?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.FishingPool -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/FishingPole?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.SwordP -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Sword?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.ShieldP -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Shield?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Hatchet -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Hatchet?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Repair -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Rapier?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Greataxe -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/GreatAxe?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Warhammer -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Warhammer?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Spear -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Spear?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Bow -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Bow?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Musket -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/Bow?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Firesttaf -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/FireStaff?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Lifestaff -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/LifeStaff?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Icestaff -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Perks/IceMagic?page=1&attributes=&perks=&sort=name&dir=asc")
                        }

                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun gemsMenu() {
        var dxMenu: Button = findViewById(R.id.Gems)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.gems_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView) as WebView
                var wbUrl = "https://newworldfans.com/db"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.all -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Gems/All?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Armor -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Gems/Armor?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Weapon -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Gems/Weapon?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Jewelry -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Gems/Jewelry?page=1&attributes=&perks=&sort=name&dir=asc")
                        }

                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun furnitureMenu() {
        var dxMenu: Button = findViewById(R.id.Furniture)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.furniture_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView) as WebView
                var wbUrl = "https://newworldfans.com/db"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.all -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/All?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Beds -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Beds?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Chairs -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Chairs?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Decorations -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Decorations?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Lighting -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Lighting?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Misc -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Misc?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Pets -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Pets?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Shelves -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Shelves?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Storage -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Storage?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Tables -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Tables?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Trophies -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Trophies?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Vegetation -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Furniture/Vegetation?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun recipesMenu() {
        var dxMenu: Button = findViewById(R.id.Recipes)
        dxMenu.setOnClickListener {

            val menu = PopupMenu(this, dxMenu)
            menu.menuInflater.inflate(R.menu.recpies_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView) as WebView
                var wbUrl = "https://newworldfans.com/db"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.all -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/")
                        }
                        R.id.Camp -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Camp?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Arcana -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Arcana?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Armoring -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Armoring?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Cooking -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Cooking?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Engineering -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Engineering?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Furnishing -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Furnishing?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Jewelcrafting -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Jewelcrafting?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Weaponsmithing -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Weaponsmithing?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Leatherworking -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Leatherworking?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Smelting -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Smelting?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Stonecutting -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Stonecutting?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Weaving -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Weaving?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.Woodworking -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Recipes/Woodworking?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun itemsMenu() {
        var itemsMenu: Button = findViewById(R.id.items)
        itemsMenu.setOnClickListener {

            val menu = PopupMenu(this, itemsMenu)
            menu.menuInflater.inflate(R.menu.database_menu, menu.menu)
            menu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                var wb = findViewById<View>(R.id.webView) as WebView
                var wbUrl = "https://newworldfans.com/db"
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.all -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/")
                        }
                        R.id.ammo -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Ammo?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.armor -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Armor?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.consumable -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Consumable?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.resource -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Resource?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                        R.id.weapon -> {
                            var wb = findViewById<View>(R.id.webView) as WebView
                            wb.loadUrl("https://newworldfans.com/db/category/Weapon?page=1&attributes=&perks=&sort=name&dir=asc")
                        }
                    }
                    return true
                }

            })
            menu.show()
        }
    }

    private fun webView() {
        var wb = findViewById<View>(R.id.webView) as WebView
        var wbUrl = "https://newworldfans.com/db"
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
        wb.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        myWebSettings.domStorageEnabled = true
        myWebSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
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
        mp = MediaPlayer.create(this@DataBaseActivity, R.raw.soundtrack)
        mp?.start()
        mp?.setOnCompletionListener { mp?.start() }
    }

    override fun onPause() {
        finish()
        mp?.pause()
        super.onPause()
    }

    private fun backBtnToHome() {
        var backBtnToHome: Button = findViewById(R.id.backBtnToHome2)
        backBtnToHome.setOnClickListener { finish() }
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

    fun NPCs(view: View) {
        var wb = findViewById<View>(R.id.webView) as WebView
        wb.loadUrl("https://newworldfans.com/db/category/NPCs?page=1&attributes=&perks=&sort=name&dir=asc")
    }

}