package com.letsgotoperfection.whatshotonsoundcloud.data

/**
 * @author hossam.
 */
object UserPreferences : WhatsHotPreferences() {
    var userToken by stringPref()
    var userName by stringPref()
}