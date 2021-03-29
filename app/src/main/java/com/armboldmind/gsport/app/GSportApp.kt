package com.armboldmind.gsport.app

import android.app.Application
import com.armboldmind.gsport.app.helpers.Configurator

class GSportApp : Application() {

    private val configurator = Configurator()

    override fun onCreate() {
        super.onCreate()
        configurator.configureAppInit(applicationContext)
    }
}