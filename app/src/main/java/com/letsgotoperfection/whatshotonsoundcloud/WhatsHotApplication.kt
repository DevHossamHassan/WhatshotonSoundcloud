package com.letsgotoperfection.whatshotonsoundcloud

import android.annotation.SuppressLint
import android.app.Application
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Build
import android.util.Log
import com.letsgotoperfection.whatshotonsoundcloud.data.crawlers.Crawler
import com.letsgotoperfection.whatshotonsoundcloud.data.local.WhatsHotPreferences

/**
 * @author hossam.
 */
class WhatsHotApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WhatsHotPreferences.init(this)
        startCrawling()
    }

    @SuppressLint("NewApi")
    fun startCrawling() {
        // get the jobScheduler instance from current context
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val jobScheduler: JobScheduler = applicationContext.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val jobService = ComponentName(applicationContext, Crawler::class.java)
            // define that the job will run periodically in intervals of 10 seconds

            // Crawler provides the implementation for the job
            val jobInfo: JobInfo = JobInfo.Builder(7878, jobService).setPeriodic(1000 * 30 * 60).build()
            // schedule/start the job
            val result = jobScheduler.schedule(jobInfo)
            if (result == JobScheduler.RESULT_SUCCESS)
                Log.d("WhatsHotOnSoundCloud", "Successfully scheduled job: " + result)
            else
                Log.e("WhatsHotOnSoundCloud", "RESULT_FAILURE: " + result)

        } else {
            Log.e("WhatsHotOnSoundCloud", "JobSchedulers are not supported " +
                    "on APIs prior API_21 therefore Crawler will be able to work.")
        }
    }
}