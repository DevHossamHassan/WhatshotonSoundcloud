package com.letsgotoperfection.whatshotonsoundcloud

import android.app.Application
import com.letsgotoperfection.whatshotonsoundcloud.data.WhatshotPrefrences

/**
 * @author hossam.
 */
class WhatsHotApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WhatshotPrefrences.init(this)
    }
}