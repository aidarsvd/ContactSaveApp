package ru.mitapp.contacts

import android.app.Application
import android.content.Context
import ru.mitapp.contacts.service.utils.SharedPreference

class ContactApp : Application(){

    companion object{
        lateinit var context: Context
        lateinit var sharedPreferences: SharedPreference
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        sharedPreferences = SharedPreference(applicationContext)
    }

}