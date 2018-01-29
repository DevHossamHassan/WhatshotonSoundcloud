package com.letsgotoperfection.whatshotonsoundcloud.extentions

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author hossam.
 */
object InternetUtils {

    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return manager.activeNetworkInfo != null && manager.activeNetworkInfo
                .isConnectedOrConnecting
    }
}
