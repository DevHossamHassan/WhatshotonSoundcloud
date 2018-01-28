package com.letsgotoperfection.whatshotonsoundcloud.data.local

/**
 * @author hossam.
 */
object UserPreferences : WhatsHotPreferences() {
    var userToken by stringPref()
    var userName by stringPref()
}