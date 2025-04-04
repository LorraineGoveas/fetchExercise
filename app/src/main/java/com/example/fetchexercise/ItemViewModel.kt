package com.example.fetchexercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel(): ViewModel() {
    private val _itemData = MutableLiveData<List<ItemData>>()
    val itemData: LiveData<List<ItemData>> get() = _itemData

    fun fetchItems(){
        viewModelScope.launch {
            val items = RetrofitInstance.api.getItems()
            _itemData.value = items.filter { !it.name.isNullOrBlank() }.sortedWith(compareBy<ItemData>{it.listId}.thenBy{
                it.name.substringAfter("Item ").toInt()
            })
        }
    }
}