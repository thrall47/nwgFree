package com.nwg.newworlduide

import android.content.Intent
import android.media.MediaPlayer
import android.view.WindowManager
import com.daimajia.androidanimations.library.Techniques
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import com.viksaa.sssplash.lib.cnst.Flags
import com.viksaa.sssplash.lib.model.ConfigSplash

class SplashActivity : AwesomeSplash() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun initSplash(configSplash: ConfigSplash?) {
        /* you don't have to override every property */
        mediaPlayer = MediaPlayer.create(this, R.raw.neworldd)
        mediaPlayer.start()

        // full screen with no status bar
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        supportActionBar?.hide()

        //Customize Circular Reveal
        configSplash?.backgroundColor = R.color.blank; //any color you want form colors.xml
        configSplash?.animCircularRevealDuration = 2000; //int ms
        configSplash?.revealFlagX = Flags.REVEAL_TOP;  //or Flags.REVEAL_LEFT
        configSplash?.revealFlagY = Flags.REVEAL_LEFT; //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash?.logoSplash = R.drawable.high_icon; //or any other drawable
        configSplash?.animLogoSplashDuration = 1500; //int ms
//        configSplash?.animLogoSplashTechnique = Techniques.Pulse; //choose one form Techniques

        //Customize Title
        configSplash?.titleSplash = "New World Guide";
        configSplash?.titleTextColor = R.color.grey;
        configSplash?.titleTextSize = 30f; //float value
        configSplash?.animTitleDuration = 3000;
        configSplash?.animTitleTechnique = Techniques.Flash;
//        configSplash?.titleFont = "font/skita.ttf" //provide string to your font located in assets/fonts/
    }

    override fun animationsFinished() {
        val i = Intent(this, DrawerActivity::class.java)
        startActivity(i)
        finish()
        mediaPlayer.release()
    }



}