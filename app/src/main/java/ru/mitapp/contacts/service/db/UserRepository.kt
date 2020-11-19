package ru.mitapp.contacts.service.db

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllUsers()

    suspend fun addData(user: User){
        userDao.addUser(user)
    }
}