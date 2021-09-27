package com.nwg.newworlduide


import android.content.Intent
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        rgOne()

        mute()

        language()

    }

    private fun language() {
        val rgM: RadioGroup = findViewById(R.id.rg3)
        rgM.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.English) {
                changeLanguage("${null}")
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("language", "${null}")
            }
            if (checkedId == R.id.Deutsch){
                changeLanguage("DE")
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("language", "DE")
            }
            if (checkedId == R.id.French){
                changeLanguage("FR")
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("language", "FR")
            }
        }
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val size = pref.getString("language", "${null}")
        when (size) {
            "${null}" -> rgM.check(R.id.English)
            "DE" -> rgM.check(R.id.Deutsch)
            "FR" -> rgM.check(R.id.French)
        }
        if (size == "${null}"){
            rgM.check(R.id.English)
        }
    }

    private fun mute() {
        val rgM: RadioGroup = findViewById(R.id.rg2)
        var amanager = getSystemService(AUDIO_SERVICE) as AudioManager

        rgM.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.musicOff) {
                changeMusic("musicoff")
                amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true)
            }
            if (checkedId == R.id.musicOn){
                changeMusic("musicon")
                amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
            }
        }
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val size = pref.getString("music", "musicon")
        when (size) {
            "musicoff" -> rgM.check(R.id.musicOff)
            "musicon" -> rgM.check(R.id.musicOn) }
    }

    private fun rgOne() {
        var rg: RadioGroup = findViewById(R.id.rg)
        rg.setOnCheckedChangeListener { group, checkedId ->

            val back: Button = findViewById(R.id.backBtnFromSettings)
            if (checkedId == R.id.Website) {
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("source", "website-news")
                changeSource("website-news")
                back.setOnClickListener {
                    back.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
                    onBackPressed() }
            }
            if (checkedId == R.id.Twitter) {
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("source", "twitter")
                changeSource("twitter")
                back.setOnClickListener {
                    back.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
                    onBackPressed() }
            }
            if (checkedId == R.id.Reddit) {
                var i = Intent(this, DrawerActivity::class.java)
                i.putExtra("source", "reddit")
                changeSource("reddit")
                back.setOnClickListener {
                    back.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
                    onBackPressed() }
            }

        }
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val size = pref.getString("source", "website-news")
        when (size) {
            "website-news" -> rg.check(R.id.Website)
            "twitter" -> rg.check(R.id.Twitter)
            "reddit" -> rg.check(R.id.Reddit)
        }
    }

    fun changeSource(source: String){
        val pref = getSharedPreferences("settings", MODE_PRIVATE).edit()
        pref.putString("source", source)
        pref.apply()
    }

    fun changeMusic(music: String){
        val pref = getSharedPreferences("settings", MODE_PRIVATE).edit()
        pref.putString("music", music)
        pref.apply()
    }

    fun changeLanguage(language: String){
        val pref = getSharedPreferences("settings", MODE_PRIVATE).edit()
        pref.putString("language", language)
        pref.apply()
    }

    //    fun changeFont(font: String){
//        val pref = getSharedPreferences("settings", MODE_PRIVATE).edit()
//        pref.putString("font", font)
//        pref.apply()
//    }
    override fun onPause() {
        finish()
        super.onPause()
    }

//    override fun onBackPressed() {
//        var i = Intent(this, DrawerActivity::class.java)
//        startActivity(i)
//        super.onBackPressed()
//    }







}