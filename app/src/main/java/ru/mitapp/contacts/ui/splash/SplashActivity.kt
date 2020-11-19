package ru.mitapp.contacts.ui.splash

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.app.ActivityCompat
import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.R
import ru.mitapp.contacts.ui.first.OnBoardingActivity
import ru.mitapp.contacts.ui.list.MainActivity
import java.util.jar.Manifest

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if(ContactApp.sharedPreferences.isFirstStart){
                startActivity(Intent(this, OnBoardingActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 500)

    }



}