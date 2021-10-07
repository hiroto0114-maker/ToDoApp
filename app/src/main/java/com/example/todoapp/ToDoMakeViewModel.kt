package com.example.todoapp

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import java.util.*

class ToDoMakeViewModel : ViewModel(){
    val title = MutableLiveData<String>()
    val scheduledDate = MutableLiveData<Date>()
    val isButtonEnabled = MediatorLiveData<Boolean>()
    //private val observer = Observer<Boolean>{
        //title.value?.isNotBlank()==true && (scheduledDate.value!=null)
    //}
    init {
        isButtonEnabled.addSource(title){
            title.value?.isNotBlank()==true && (scheduledDate.value!=null)
        }
        isButtonEnabled.addSource(scheduledDate){
            title.value?.isNotBlank()==true && (scheduledDate.value!=null)
        }
    }
}