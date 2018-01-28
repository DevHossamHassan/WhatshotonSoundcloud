package com.letsgotoperfection.whatshotonsoundcloud.data

/**
 * @author hossam.
 */
class UserPreferences : WhatshotPrefrences() {
    var userTokn by stringPref()
    var userName by stringPref()
}