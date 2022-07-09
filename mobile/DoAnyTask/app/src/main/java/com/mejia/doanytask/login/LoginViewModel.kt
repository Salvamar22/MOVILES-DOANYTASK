package com.mejia.doanytask.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelmadriz.dummydictionary.repository.LoginRepository
import com.mejia.doanytask.R
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class LoginUiStatus {
    object Resume : LoginUiStatus()
    object Loading : LoginUiStatus()
    class Error(val exception: Exception) : LoginUiStatus()
    data class Success(val token: String) : LoginUiStatus()
}

class LoginViewModel( private  val repository: LoginRepository): ViewModel() {
    val userField = MutableLiveData("")
    val passwordField = MutableLiveData("")
    val activities = MutableLiveData<List<Activity>>( null)
    private val _status = MutableLiveData<LoginUiStatus>(LoginUiStatus.Resume)
    val status: LiveData<LoginUiStatus>
        get() = _status

    fun onLogin() {
        R.layout.activity_login
        _status.value = LoginUiStatus.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when (val response = repository.login(
                    userField.value.toString(),
                    passwordField.value.toString()
                )) {
                    is ApiResponse.Error -> LoginUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> LoginUiStatus.Resume
                    is ApiResponse.Success -> LoginUiStatus.Success(response.data)
                }
            )
        }
    }
}