package ru.mitapp.contacts.service.base

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.util.*

abstract class BaseFragment<DataBinding : ViewDataBinding>(private val layoutId : Int) : Fragment() {

    lateinit var binding: DataBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        init()

        return binding.root
    }

    abstract fun init()
}