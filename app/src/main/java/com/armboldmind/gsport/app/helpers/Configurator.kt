package com.armboldmind.gsport.app.helpers

import android.content.Context
import com.armboldmind.gsport.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Configurator {

    fun configureAppInit(context: Context) {
        initKoin(context)
    }

    private fun initKoin(context: Context) {
        val appComponent = listOf(
            PresentationModule
        )

        startKoin {
            androidContext(context)
            modules(appComponent)
        }
    }
}