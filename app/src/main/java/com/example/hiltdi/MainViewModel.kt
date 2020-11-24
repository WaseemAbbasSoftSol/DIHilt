package com.example.hiltdi

import androidx.annotation.WorkerThread
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdi.data.remote.RemoteRepository
import com.example.hiltdi.model.DocumentModel
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
    private val adapter: SampleAdapter,
    private val repository: RemoteRepository
) : ViewModel(){
    fun getCount() = adapter.getItemsCount()

    val data: LiveData<DocumentModel>
    private val _data = MutableLiveData<DocumentModel>()

    init {
        data = _data

        loadData()
    }

    @WorkerThread
    private fun loadData() {
        viewModelScope.launch {
            try {
                val response = repository.getData()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _data.postValue(it)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

}