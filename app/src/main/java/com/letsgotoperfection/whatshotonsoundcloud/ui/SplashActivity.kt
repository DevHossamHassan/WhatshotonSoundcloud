package com.letsgotoperfection.whatshotonsoundcloud.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.letsgotoperfection.whatshotonsoundcloud.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val r = Runnable {
            run {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        val h = Handler()
        h.postDelayed(r, 2000)

    }
}
