package com.onelenyk.mybootcounterapplication

import android.app.Application
import android.content.Context


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        val context: Context by lazy {
            instance.applicationContext
        }

        lateinit var instance: MainApplication
            private set
    }

/*    override fun getWorkManagerConfiguration(): Configuration {
        val handler = DeferredWorkHandler()
        val factory = MyWorkerFactory(handler)

        return Configuration.Builder()
                .setMinimumLoggingLevel(android.util.Log.DEBUG)
                .setWorkerFactory(factory)
                .build()
    }*/
}