package com.letsgotoperfection.whatshotonsoundcloud

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

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
