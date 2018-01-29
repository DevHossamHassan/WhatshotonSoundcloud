package com.letsgotoperfection.whatshotonsoundcloud.ui


import com.letsgotoperfection.whatshotonsoundcloud.R
import com.letsgotoperfection.whatshotonsoundcloud.ui.base.BaseActivity
import com.letsgotoperfection.whatshotonsoundcloud.ui.hottracks.HotTracksFragment

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun getTitleResourceId(): String {
        return getString(R.string.app_name)
    }

    override fun init() {
        NavigationManager.attachAsRoot(this, HotTracksFragment())
    }
}
