package com.letsgotoperfection.whatshotonsoundcloud

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.letsgotoperfection.whatshotonsoundcloud.data.UserPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "User Token is : " + UserPreferences.userToken, Toast.LENGTH_SHORT).show()
    }
}
