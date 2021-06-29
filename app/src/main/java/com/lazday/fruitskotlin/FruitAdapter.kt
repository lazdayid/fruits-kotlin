package com.lazday.fruitskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter (
    var fruits: ArrayList<FruitModel>,
    val listener: OnAdapterListener
) : RecyclerView.Adapter<FruitAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_fruit, parent, false )
    )

    override fun getItemCount() = fruits.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.text.text = fruit.name
        holder.image.setImageResource( fruit.image )
        holder.itemView.setOnClickListener {
            listener.onClick( fruit )
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image)
        val text = view.findViewById<TextView>(R.id.text)
    }

    fun add(data: FruitModel) {
        fruits.add( data )
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(fruitModel: FruitModel)
    }

}