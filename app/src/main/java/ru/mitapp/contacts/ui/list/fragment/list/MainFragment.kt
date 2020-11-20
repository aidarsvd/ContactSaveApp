package ru.mitapp.contacts.ui.list.fragment.list

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.R
import ru.mitapp.contacts.databinding.FragmentMainBinding
import ru.mitapp.contacts.service.base.BaseFragment
import ru.mitapp.contacts.ui.list.adapter.ContactsAdapter
import ru.mitapp.contacts.ui.list.fragment.add.model.InsertDataBaseViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    lateinit var viewModel: InsertDataBaseViewModel
    override fun init() {
        viewModel = ViewModelProvider(this).get(InsertDataBaseViewModel::class.java)
        binding.name.setText(ContactApp.sharedPreferences.name)

        val adapter = ContactsAdapter()
        val recyclerView = binding.contacts

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.infoAddFragment)
        }
    }

}