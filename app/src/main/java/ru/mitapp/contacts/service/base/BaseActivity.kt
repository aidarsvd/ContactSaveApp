package ru.mitapp.contacts.service.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<DataBinding : ViewDataBinding>(private val layoutId: Int) :
    AppCompatActivity(){

    lateinit var binding: DataBinding

    private val jobs = Job()
    private val coroutineContext: CoroutineContext
        get() = jobs + Dispatchers.IO
    val scope = CoroutineScope(coroutineContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        init()
    }

    abstract fun init()
}