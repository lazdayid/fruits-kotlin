package com.lazday.fruitskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fruitModel = intent.getSerializableExtra("intent_fruit") as FruitModel

        supportActionBar!!.title = fruitModel.name

        val image = findViewById<ImageView>(R.id.image)
        image.setImageResource(fruitModel.image)
    }
}