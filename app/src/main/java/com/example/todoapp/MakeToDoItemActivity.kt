package com.example.todoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup

class MakeToDoItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_to_do_item)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentMenuThanks, ToMakeListFragment::class.java, null).commit()
    }
}