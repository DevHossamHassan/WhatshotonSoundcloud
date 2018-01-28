package com.letsgotoperfection.whatshotonsoundcloud

import android.app.Application
import com.letsgotoperfection.whatshotonsoundcloud.data.WhatsHotPreferences

/**
 * @author hossam.
 */
class WhatsHotApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WhatsHotPreferences.init(this)
    }
}