package com.example.todoapp
import androidx.lifecycle.ViewModel

/**
 * ToDoリストを表示させるためのビューモデル
 */
class ToDoListViewModel : ViewModel(){
    var menuList: MutableList<MutableMap<String, String>> = createToDoAppList()

    //ToDoリストの仮置きのデータ
    private fun createToDoAppList(): MutableList<MutableMap<String, String>> {
        // ToDoリストを表示させるためのリスト
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        var menu = mutableMapOf<String, String>("title" to "タイトル", "time" to "6/9 23:59")

        //仮置きのデータを３回登録する。３回に意味はなし。
        menuList.add(menu)
        menuList.add(menu)
        menuList.add(menu)

        return menuList
    }
}