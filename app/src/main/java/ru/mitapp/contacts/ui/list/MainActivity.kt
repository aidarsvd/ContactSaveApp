package ru.mitapp.contacts.ui.list



import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.R
import ru.mitapp.contacts.databinding.ActivityMainBinding
import ru.mitapp.contacts.service.base.BaseActivity
import ru.mitapp.contacts.service.utils.isPermissionWrite

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun init() {
        isPermissionWrite()
        binding.name.setText(ContactApp.sharedPreferences.name)

    }




}