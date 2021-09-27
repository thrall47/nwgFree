package com.nwg.newworlduide

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        backBtnClickk()

        contactMe()

        contactShady()

        newWorldDiscord()

        myDiscord()

        shadyDiscord()


    }

    private fun shadyDiscord() {
        val shadyDiscord: ImageButton = findViewById(R.id.shadyDiscord)
        val txt1: TextView = findViewById(R.id.setText2)
        shadyDiscord.setOnClickListener { txt1.text = "Bruh#3003"
            shadyDiscord.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))}
    }

    private fun myDiscord() {
        val myDiscord: ImageButton = findViewById(R.id.meDiscord)
        val txt1: TextView = findViewById(R.id.setText1)
        myDiscord.setOnClickListener { txt1.text = "Tokè#6679"
            myDiscord.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))}
    }

    private fun newWorldDiscord() {
        val link: ImageButton = findViewById(R.id.contactNw)
        link.setOnClickListener {
            link.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://discord.com/invite/svQNCdA")))
        }
    }

    private fun contactShady() {
        val shadyDiscord: ImageButton = findViewById(R.id.contactShady)
        val txt1: TextView = findViewById(R.id.setText3)
        shadyDiscord.setOnClickListener { txt1.text = "BeewWolf#0570"
            shadyDiscord.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
        }
    }

    private fun contactMe() {
        val contactMe: ImageButton = findViewById(R.id.contactMe)
        val i = Intent(Intent.ACTION_SEND)
        contactMe.setOnClickListener {
            i.type = "message/rfc822"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("ahmedyasserinv47@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email")
            i.putExtra(Intent.EXTRA_TEXT, "body of email")
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this@AboutActivity,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun backBtnClickk() {
        val back: Button = findViewById(R.id.backBtnFromAbout)
        var i = Intent(this, DrawerActivity::class.java)
        back.setOnClickListener {
            back.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce))
            startActivity(i)
        }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

    override fun onBackPressed() {
        var i = Intent(this, DrawerActivity::class.java)
        startActivity(i)
        super.onBackPressed()
    }


}