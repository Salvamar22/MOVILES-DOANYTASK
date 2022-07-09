package com.mejia.doanytask.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelmadriz.dummydictionary.repository.ActivityRepository
import com.mejia.doanytask.data.model.Activity
import com.mejia.doanytask.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


sealed class ActivityUiState() {
    object Loading : ActivityUiState()
    class Error(val exception: Exception) : ActivityUiState()
    data class Success(val activities: LiveData<List<Activity>>) : ActivityUiState()
}

class ActivitiesViewModel( private  val repository: ActivityRepository): ViewModel()  {
    private val _status = MutableLiveData<ActivityUiState>(ActivityUiState.Loading)
    val status: LiveData<ActivityUiState>
        get() = _status

    fun getAllActivitys() {
        _status.value = ActivityUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _status.postValue(
                when (val response = repository.getAllActivities()) {
                    is ApiResponse.Error -> ActivityUiState.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> TODO()
                    is ApiResponse.Success -> ActivityUiState.Success(response.data)
                }
            )
        }
    }

    /*fun addActivity(activity: Activity) {
        viewModelScope.launch {
            repository.addActivity(Activity)
        }
    }*/
}