package ru.mitapp.contacts.ui.list.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_info_add.*
import kotlinx.android.synthetic.main.fragment_info_add.view.*

import ru.mitapp.contacts.R
import ru.mitapp.contacts.service.db.User
import ru.mitapp.contacts.service.utils.showToast
import ru.mitapp.contacts.ui.list.fragment.add.model.InsertDataBaseViewModel

class InfoAddFragment : Fragment() {

    lateinit var viewModel: InsertDataBaseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.mainFragment)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_info_add, container, false)

        viewModel = ViewModelProvider(this).get(InsertDataBaseViewModel::class.java)

        view.addBtn.setOnClickListener {
            insertData()
        }

        return view
    }

    private fun insertData(){
        val userName = name.text.toString()
        val userPhone = phoneNumber.text.toString()
        val userEmail = email.text.toString()
        if (inputCheck(userName,userPhone, userEmail)){
            val user = User(0, userName, userEmail, userPhone)
            viewModel.addUser(user)
            Toast.makeText(context, "Successfully added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.mainFragment)
        }else
            Toast.makeText(context, "Please fill out all fields!", Toast.LENGTH_SHORT).show()

    }

    private fun inputCheck(firstName: String, phone: String, email: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(phone) && email.isEmpty())
    }
}