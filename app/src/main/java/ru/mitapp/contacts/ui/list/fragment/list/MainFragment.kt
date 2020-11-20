package ru.mitapp.contacts.ui.list.fragment.list

import androidx.navigation.fragment.findNavController
import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.R
import ru.mitapp.contacts.databinding.FragmentMainBinding
import ru.mitapp.contacts.service.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    companion object{
        fun newInstance() = MainFragment()
    }

    override fun init() {
        binding.name.setText(ContactApp.sharedPreferences.name)
        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.infoAddFragment)
        }
    }

}