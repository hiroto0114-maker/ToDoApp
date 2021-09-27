package com.example.todoapp
import androidx.lifecycle.ViewModel

class ToDoListViewModel : ViewModel(){
    var menuList: MutableList<MutableMap<String, String>> = createToDoAppList()

    private fun createToDoAppList(): MutableList<MutableMap<String, String>> {
        // 定食メニューリスト用のListオブジェクトを用意。
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf<String, String>("title" to "タイトル", "time" to "6/9 23:59")
        menuList.add(menu)
        menuList.add(menu)
        menuList.add(menu)
        return menuList
    }
}