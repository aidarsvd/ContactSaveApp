package ru.mitapp.contacts.ui.list.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mitapp.contacts.ContactApp
import ru.mitapp.contacts.service.base.BaseViewModel
import ru.mitapp.contacts.service.db.User
import ru.mitapp.contacts.service.db.UserDataBase
import ru.mitapp.contacts.service.db.UserRepository

class MainActivityViewModel: BaseViewModel() {

    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDataBase(ContactApp.context).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addData(user)
        }
    }

}