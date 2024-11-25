package com.example.bai6_callapi2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bai6_callapi2.model.API.APIsv
import com.example.bai6_callapi2.model.API.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: APIsv
) {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users


    fun fetchUsers() {
        RetrofitInstance.api.getUsers().enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if (response.isSuccessful) {
                    _users.postValue(response.body()?.results)
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}