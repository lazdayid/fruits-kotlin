package com.lazday.fruitskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitsAdapter (
    var fruits: ArrayList<FruitsModel>
) : RecyclerView.Adapter<FruitsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_fruits, parent, false )
    )

    override fun getItemCount() = fruits.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.text.text = fruit.name
        holder.image.setImageResource( fruit.image )
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image)
        val text = view.findViewById<TextView>(R.id.text)
    }

    fun add(data: FruitsModel) {
        fruits.add( data )
        notifyDataSetChanged()
    }

}