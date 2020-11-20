package ru.mitapp.contacts.ui.list.fragment.add.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.mitapp.contacts.service.db.User
import ru.mitapp.contacts.service.db.UserDataBase
import ru.mitapp.contacts.service.db.UserRepository

class InsertDataBaseViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch {
            repository.addData(user)
        }
    }
}