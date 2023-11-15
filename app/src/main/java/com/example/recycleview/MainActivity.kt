package com.example.recycleview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    //private var colorList: ArrayList<ColorData> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rView)

        recyclerView = findViewById(R.id.rView)
        //зададим менеджер компоновки - как буду размещаться эелементы
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this,  fetchList())

}
    fun fetchList(): ArrayList<ColorData> {
        val list = arrayListOf<ColorData>()
        list.add(ColorData("Blue", Color.BLUE))
        list.add(ColorData("Red", Color.RED))
        list.add(ColorData("Black", Color.BLACK))
        list.add(ColorData("Yellow", Color.YELLOW))
        list.add(ColorData("Green", Color.GREEN))
        list.add(ColorData("Magenta", Color.MAGENTA))
        list.add(ColorData("Blue", Color.BLUE))
        list.add(ColorData("Red", Color.RED))
        list.add(ColorData("Black", Color.BLACK))
        list.add(ColorData("Yellow", Color.YELLOW))
        list.add(ColorData("Green", Color.GREEN))
        list.add(ColorData("Magenta", Color.MAGENTA))

        return list
    }
}

data class ColorData(var Colorname: String, var Colorhex: Int);

class Adapter(private val context: Context, list: ArrayList<ColorData>) : RecyclerView.Adapter<Adapter.mViewHolder>(){
    class mViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val myColorImg: View = itemView.findViewById(R.id.view)
        val myTextView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.color_item, parent, false)
        return mViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val data = list[position]
        holder.myColorImg.setBackgroundColor(data.colorHex)
        holder.myTextView.text = data.colorName
    }
}