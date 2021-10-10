package com.example.todoapp

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ToDoMakeViewModel : ViewModel(){
    val title = MutableLiveData<String>()
    val scheduledDate = MutableLiveData<String>()
    val isButtonEnabled = MediatorLiveData<Boolean>()

    init {
        isButtonEnabled.addSource(title){
            (title.value?.isNotBlank()==true) && (scheduledDate.value?.isNotBlank() == true)
        }
        isButtonEnabled.addSource(scheduledDate){
            (title.value?.isNotBlank()==true) && (scheduledDate.value?.isNotBlank() == true)
        }
    }
}