package ru.mitapp.contacts.ui.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.R
import ru.mitapp.contacts.databinding.ActivityOnBoardingBinding
import ru.mitapp.contacts.service.base.BaseActivity
import ru.mitapp.contacts.ui.list.MainActivity

class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>(R.layout.activity_on_boarding) {

    override fun init() {
        binding.startBtn.isEnabled = false
        binding.startBtn.isClickable = false
        binding.getName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.startBtn.isEnabled = false
                binding.startBtn.isClickable = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(TextUtils.isEmpty(binding.getName.text)){
                    binding.startBtn.isEnabled = false
                    binding.startBtn.isClickable = false
                }else{
                    binding.startBtn.isEnabled = true
                    binding.startBtn.isClickable = true
                }

            }

            override fun afterTextChanged(s: Editable?) {
                if(TextUtils.isEmpty(binding.getName.text)){
                    binding.startBtn.isEnabled = false
                    binding.startBtn.isClickable = false
                }else{
                    binding.startBtn.isEnabled = true
                    binding.startBtn.isClickable = true
                }

            }
        })

        binding.startBtn.setOnClickListener{
            ContactApp.sharedPreferences.name = binding.getName.text.toString()
            ContactApp.sharedPreferences.isFirstStart = false
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}