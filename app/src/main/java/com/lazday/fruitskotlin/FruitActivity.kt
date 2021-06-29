package com.lazday.fruitskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FruitActivity : AppCompatActivity(), FruitAdapter.OnAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        val listFruit = arrayListOf<FruitModel>(
            FruitModel("apple", R.drawable.apple),
            FruitModel("avocado", R.drawable.avocado),
            FruitModel("banana", R.drawable.banana),
            FruitModel("cherry", R.drawable.cherry),
            FruitModel("grape", R.drawable.grape),
            FruitModel("orange", R.drawable.orange),
            FruitModel("paprika", R.drawable.paprika),
            FruitModel("pineapple", R.drawable.pineapple),
            FruitModel("strawberry", R.drawable.strawberry),
            FruitModel("tomato", R.drawable.tomato),
            FruitModel("watermelon", R.drawable.watermelon),
        )

        val list = findViewById<RecyclerView>(R.id.list)
//        val fruitAdapter = FruitAdapter(arrayListOf(), this)
        val fruitAdapter = FruitAdapter(listFruit, this)
        list.adapter = fruitAdapter

        var index = 0
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            if (index < 11) {
                fruitAdapter.add( listFruit[ index ] )
                list.scrollToPosition( index )
                index ++
            } else {
                Toast.makeText(applicationContext, "All fruits are complete!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(fruitModel: FruitModel) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("intent_fruit", fruitModel)
        startActivity( intent )
    }

}