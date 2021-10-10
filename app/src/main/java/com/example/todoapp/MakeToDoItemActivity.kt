package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MakeToDoItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_to_do_item)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentMenuThanks, ToMakeListFragment::class.java, null).commit()
    }
}