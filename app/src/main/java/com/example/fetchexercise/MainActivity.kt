package com.example.fetchexercise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val itemViewModel: ItemViewModel by viewModels()
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemAdapter: ItemRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        itemRecyclerView = findViewById(R.id.item_recycler_view)
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerView.setHasFixedSize(true)
        itemAdapter = ItemRecyclerView(emptyList())
        itemRecyclerView.adapter = itemAdapter

        itemViewModel.fetchItems()

        itemViewModel.itemData.observe(this){
            items ->
            itemAdapter.setItems(items)
        }
    }
}