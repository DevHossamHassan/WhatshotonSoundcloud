package com.letsgotoperfection.whatshotonsoundcloud

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    val REQUEST_CODE = 92849489
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val i = Intent(this, MainActivity::class.java)
        val r = Runnable {
            run {
                startActivity(i)
                finish()
            }
        }
        val h = Handler()
        h.postDelayed(r, 3000)


    }
}
