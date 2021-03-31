package com.lazday.fruitskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFruit = arrayListOf<FruitsModel>(
            FruitsModel("apple", R.drawable.apple),
            FruitsModel("avocado", R.drawable.avocado),
            FruitsModel("banana", R.drawable.banana),
            FruitsModel("cherry", R.drawable.cherry),
            FruitsModel("grape", R.drawable.grape),
            FruitsModel("orange", R.drawable.orange),
            FruitsModel("paprika", R.drawable.paprika),
            FruitsModel("pineapple", R.drawable.pineapple),
            FruitsModel("strawberry", R.drawable.strawberry),
            FruitsModel("tomato", R.drawable.tomato),
            FruitsModel("watermelon", R.drawable.watermelon),
        )

        val list = findViewById<RecyclerView>(R.id.list)
        val fruitsAdapter = FruitsAdapter(arrayListOf())
//        val fruitsAdapter = FruitsAdapter(listFruit)
        list.adapter = fruitsAdapter

        var index = 0
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            if (index < 11) {
                fruitsAdapter.add( listFruit[ index ] )
                list.scrollToPosition( index )
                index ++
            } else {
                Toast.makeText(applicationContext, "all fruits are complete!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}