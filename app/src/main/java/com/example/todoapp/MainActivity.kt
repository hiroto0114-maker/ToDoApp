package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
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

        val adapter = MyRecyclerViewAdapter(viewModel.menuList, object : MyRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intentDetailToDoItem = Intent(this@MainActivity,DetailToDoAppActivity::class.java)
                startActivity(intentDetailToDoItem)
            }
        })
        recyclerView.adapter = adapter

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.title)
        val timeText: TextView = itemView.findViewById(R.id.time)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
        val itemLayout: LinearLayout = itemView.findViewById(R.id.toDoDetail)

    }
    class MyRecyclerViewAdapter(val mutableList: MutableList<MutableMap<String, String>>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return MyViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.titleText.text = mutableList[position]["title"]
            holder.timeText.text= mutableList[position]["time"]
            holder.itemLayout.setOnClickListener{
                listener.onItemClick(position)
            }
        }
        override fun getItemCount(): Int = mutableList.size
        interface OnItemClickListener {
            fun onItemClick(position: Int)
        }

    }
    fun onMakeToDoItemClick(view: View){
        val intentMakeToDoItem = Intent(this@MainActivity,MakeToDoItemActivity::class.java)
        startActivity(intentMakeToDoItem)
    }
}