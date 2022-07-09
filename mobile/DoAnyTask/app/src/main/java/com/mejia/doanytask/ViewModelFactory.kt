package com.mejia.doanytask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manuelmadriz.dummydictionary.repository.ActivityRepository
import com.manuelmadriz.dummydictionary.repository.LoginRepository
import com.mejia.doanytask.activities.ActivitiesViewModel
import com.mejia.doanytask.login.LoginViewModel


class ViewModelFactory<R>(private val repository: R) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActivitiesViewModel::class.java)) {
            return ActivitiesViewModel(repository as ActivityRepository) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository as LoginRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}