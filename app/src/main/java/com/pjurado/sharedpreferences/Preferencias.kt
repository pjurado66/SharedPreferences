package com.pjurado.sharedpreferences

import android.content.Context

class Preferencias(context: Context) {
    val PREFS_NAME = "com.pjurado.sharedpreferences"
    val SHARED_NAME = "shared_name"
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var name
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()
}