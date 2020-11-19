package ru.mitapp.contacts.service.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun Activity.isPermissionWrite(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            }
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 23)
            false
        } else {
            true
        }

    }

    return true
}

fun Context.showToast(toastMessage : String){
    Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImageUrl(imageUrl : String){
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}
