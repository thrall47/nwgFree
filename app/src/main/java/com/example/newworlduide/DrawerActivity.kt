package com.nwg.newworlduide

import android.content.ComponentCallbacks2
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.ContextThemeWrapper
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.nwg.newworlduide.databinding.ActivityDrawerBinding

class DrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDrawerBinding
    var mp: MediaPlayer? = null
    var muteBtn: Boolean = false
    var adCounter = 1
    var adCounterGD = 1
    var adCounterBD = 1
    var adCounterMP = 1
    private var mInterstitialAd: InterstitialAd? = null
    private var mInterstitialAdGD: InterstitialAd? = null
    private var mInterstitialAdBD: InterstitialAd? = null
    private var mInterstitialAdMP: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        MobileAds.initialize(this)

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-2551615375825499/3223290171", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {

//                    mInterstitialAd = null
                }
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd

                }
            })

        var adRequestGD = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-2551615375825499/5204318196", adRequestGD,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {

//                    mInterstitialAd = null
                }
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAdGD = interstitialAd

                }
            })

        var adRequestBD = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-2551615375825499/4677688670", adRequestBD,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {

//                    mInterstitialAd = null
                }
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAdBD = interstitialAd

                }
            })

        var adRequestMP = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-2551615375825499/3364607004", adRequestMP,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {

//                    mInterstitialAd = null
                }
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAdMP = interstitialAd

                }
            })




        drawerNav()

        loadNews()

        adMob()

        backgroundMusic()

        popUpMenu()


    }


    fun noAds(view: View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("market://details?id=com.nwg.newworlduidepro")
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
        startActivity(intent)
    }

    private fun backgroundMusic() {
        mp = MediaPlayer.create(this@DrawerActivity, R.raw.soundtrack)
        mp?.start()
        mp?.setOnCompletionListener { mp?.start() }
    }

    private fun popUpMenu() {
        var popUpMenu: Button = findViewById(R.id.ham_menu)
        popUpMenu.startAnimation(AnimationUtils.loadAnimation(popUpMenu.context, R.anim.bounce))
        supportActionBar
        popUpMenu.setOnClickListener {

//            val menu = PopupMenu(this, popUpMenu)
            val wrapper: Context = ContextThemeWrapper(this, R.style.MyToolbarStyle)
            val popup = PopupMenu(wrapper, popUpMenu)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.DB -> {
                        var i = Intent(this@DrawerActivity, DataBaseActivity::class.java)
                            i.putExtra("mute", muteBtn)

                            if (adCounter % 3 != 0){
                                startActivity(i)
                                adCounter++
                            }
                            if (mInterstitialAd != null) {
                                if (adCounter % 3 == 0){
                                    startActivity(i)
                                    val handler = Handler(Looper.getMainLooper())
                                    handler.postDelayed({ mInterstitialAd?.show(this@DrawerActivity) }, 50) }
                                mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                                    override fun onAdDismissedFullScreenContent() {
                                        startActivity(i)}
                                }
                            }

                        }
                        R.id.guide -> {
                            var i = Intent(this@DrawerActivity, GuidesActivity::class.java)
                            i.putExtra("mute", muteBtn)

                            if (adCounterGD % 3 != 0){
                                startActivity(i)
                                adCounterGD++
                            }
                            if (mInterstitialAdGD != null) {
                                if (adCounterGD % 3 == 0){
                                    startActivity(i)
                                    val handler = Handler(Looper.getMainLooper())
                                    handler.postDelayed({ mInterstitialAdGD?.show(this@DrawerActivity) }, 50) }
                                mInterstitialAdGD?.fullScreenContentCallback = object : FullScreenContentCallback() {
                                    override fun onAdDismissedFullScreenContent() {
                                        startActivity(i)}
                                    }
                                }
                        }
                        R.id.builds -> {
                            var i = Intent(this@DrawerActivity, BuildsActivity::class.java)
                            i.putExtra("mute", muteBtn)

                            if (adCounterBD % 3 != 0){
                                startActivity(i)
                                adCounterBD++
                            }
                            if (mInterstitialAdBD != null) {
                                if (adCounterBD % 3 == 0){
                                    startActivity(i)
                                    val handler = Handler(Looper.getMainLooper())
                                    handler.postDelayed({ mInterstitialAdBD?.show(this@DrawerActivity) }, 50) }
                                mInterstitialAdBD?.fullScreenContentCallback = object : FullScreenContentCallback() {
                                    override fun onAdDismissedFullScreenContent() {
                                        startActivity(i)}
                                }
                            }
                        }
                        R.id.map -> {
                            var i = Intent(this@DrawerActivity, MapActivity::class.java)
                            i.putExtra("mute", muteBtn)

                            if (adCounterMP % 3 != 0){
                                startActivity(i)
                                adCounterMP++
                            }
                            if (mInterstitialAdMP != null) {
                                if (adCounterMP % 3 == 0){
                                    startActivity(i)
                                    val handler = Handler(Looper.getMainLooper())
                                    handler.postDelayed({ mInterstitialAdMP?.show(this@DrawerActivity) }, 50) }
                                mInterstitialAdMP?.fullScreenContentCallback = object : FullScreenContentCallback() {
                                    override fun onAdDismissedFullScreenContent() {
                                        startActivity(i)}
                                }
                            }
                        }

                    }
                    return true
                }

            })
            popup.show()
        }
    }

    fun adMob() {
        val mAdView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    fun drawerNav() {
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDrawer.toolbar)

//        val drawerLayout: DrawerLayout = binding.drawerLayout
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_drawer)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)




//        navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_gallery -> {
//                    Intent(this, Builds::class.java)
//                    true
//                }
//                else -> false
//            }
//        }
    }

    fun loadNews() {
        val progress: ProgressBar = findViewById(R.id.pb)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newworldfans.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

//        val src = intent.getStringExtra("source")
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val source = pref.getString("source", "website-news")
//        val language = pref.getString("language", "${null}")
        val callable = retrofit.create(CallableInterface::class.java)
        val getNews = callable.getNews(source)
        getNews.enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                progress.visibility = View.GONE
                val news = response.body()
                val articles = news
                showNews(articles)
                Log.d("jsoon", articles.toString()  )
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                progress.visibility = View.GONE
                Toast.makeText(this@DrawerActivity, "Failed to show up the data, please check your internet connection and try again later", Toast.LENGTH_SHORT).show();
                Log.d("json", "${t.localizedMessage} ")
            }
        })
    }

    fun showNews(articles: List<Article>?){
        val rv : RecyclerView = findViewById(R.id.rv)
        val manager = LinearLayoutManager(this)
        rv.layoutManager = manager
        val adapter = NewsAdpater(this, articles)
        rv.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.refresh, menu)
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id: Int = item.itemId
        if (id == R.id.item_refresh){
                loadNews()
        }
        if (id == R.id.mute){
            if (muteBtn == false) {
                item.setIcon(R.drawable.mute_on)
                mp?.setVolume(0F, 0F)
                mp?.pause()
            }
            if (muteBtn == true) {
                item.setIcon(R.drawable.ic_baseline_music_off_24)
                mp?.setVolume(1F, 1F)
                mp?.start()
            }
            muteBtn = if (muteBtn == false) true else false
        }
        if (id == R.id.action_settings){
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
        }
        if (id == R.id.about){
            val i = Intent(this, AboutActivity::class.java)
            startActivity(i)
        }
        if (id == R.id.rate){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("market://details?id=com.nwg.newworlduide")
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val exitDialog = ExitDialog()
        exitDialog.isCancelable = false
        exitDialog.show(supportFragmentManager, null)
    }

    override fun onDestroy() {
        mp?.stop()
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
        mp?.start()
        loadNews()
        super.onResume()
    }

    override fun onPause() {
        mp?.pause()
        super.onPause()
    }




}


