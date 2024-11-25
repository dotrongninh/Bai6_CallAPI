package com.example.bai6_callapi2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bai6_callapi2.model.User
import com.example.bai6_callapi2.model.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: UserRepository
) :ViewModel(){
    //private val repository = UserRepository()
    val users: LiveData<List<User>> = repository.users

    fun fetchUsers() {
        repository.fetchUsers()
    }
}