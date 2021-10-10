package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: ToDoListViewModel = ViewModelProvider(this).get(ToDoListViewModel::class.java)
        recyclerView = findViewById(R.id.lvMenu)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyRecyclerViewAdapter(viewModel.menuList)
        recyclerView.adapter = adapter
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView
        val timeText: TextView
        private val checkBox: CheckBox
        init {
            titleText = itemView.findViewById(R.id.title)
            timeText = itemView.findViewById(R.id.time)
            checkBox = itemView.findViewById(R.id.checkbox)
        }
    }
    class MyRecyclerViewAdapter(val mutableList: MutableList<MutableMap<String, String>>) : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return MyViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.titleText.text = mutableList[position].get("title")
            holder.timeText.text= mutableList[position].get("time")
        }
        override fun getItemCount(): Int = mutableList.size

    }
    fun onMakeToDoItemClick(view: View){
        val intentMakeToDoItem = Intent(this@MainActivity,MakeToDoItemActivity::class.java)
        startActivity(intentMakeToDoItem)
    }
}