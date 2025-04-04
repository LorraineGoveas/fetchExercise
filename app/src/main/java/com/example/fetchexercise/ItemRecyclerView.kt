package com.example.fetchexercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemRecyclerView (var itemsList: List<ItemData>): Adapter<ItemRecyclerView.ItemsViewHolder>(){
    class ItemsViewHolder(view: View): ViewHolder(view) {
        val itemName = view.findViewById<TextView>(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
       holder.itemName.text = itemsList[position].name
    }

    fun setItems(items: List<ItemData>){
        itemsList = items
        notifyDataSetChanged()
    }
}