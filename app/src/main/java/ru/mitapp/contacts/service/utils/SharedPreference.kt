package ru.mitapp.contacts.service.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val IS_FIRST_START = "is_first_start"
private const val NAME = ""
private const val PREF_NAME = "ru.mitapp.contacts.APP_PREF"

class SharedPreference(context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isFirstStart: Boolean
        get() {
            return pref.getBoolean(IS_FIRST_START, true)
        }
        set(value) {
            pref.edit().putBoolean(IS_FIRST_START, value).apply()
        }

    var name: String?
        get() {
            return pref.getString(NAME, "")
        }
        set(value) {
            pref.edit().putString(NAME, value).apply()
        }


}