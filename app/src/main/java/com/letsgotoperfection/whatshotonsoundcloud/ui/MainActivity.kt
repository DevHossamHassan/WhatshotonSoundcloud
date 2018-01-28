package com.letsgotoperfection.whatshotonsoundcloud.ui

import com.letsgotoperfection.kotlin_clean_architecture_mvp_sample.base.BaseActivity
import com.letsgotoperfection.whatshotonsoundcloud.R

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun getTitleResourceId(): String {
        return getString(R.string.app_name)
    }

    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
