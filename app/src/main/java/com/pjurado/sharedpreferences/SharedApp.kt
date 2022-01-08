package com.pjurado.sharedpreferences

import android.app.Application

class SharedApp: Application() {
    companion object{
        lateinit var prefs: Preferencias
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferencias(applicationContext)
    }
}