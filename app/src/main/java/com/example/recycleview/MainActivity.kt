package com.example.recycleview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        recyclerView.adapter = Adapter(this,  fetchList(), this)

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

    fun onCellClickListener(text: String, context: Context) {
        Toast.makeText(context,"IT'S  " + text, LENGTH_SHORT).show();
    }

}

data class ColorData(var Colorname: String, var Colorhex: Int);

class Adapter(private val context: Context, private val colorList: ArrayList<ColorData>, private val cellClickListener: MainActivity): RecyclerView.Adapter<Adapter.myViewHolder>() {
    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val myColorImg: View = itemView.findViewById(R.id.view)
        val myTextView: TextView = itemView.findViewById(R.id.textView)
    }

    //вызывается каждый раз, когда надо создать новый элемент списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item, parent, false)
        return myViewHolder(view)
    }

    //количество элементов
    override fun getItemCount(): Int {
        return colorList.size
    }
    interface CellClickListener {
        fun onCellClickListener(text: String, context: Context) {
            Toast.makeText(context,"IT'S  " + text, LENGTH_SHORT).show();
        }
    }
    //связь данных с представлением view
    override fun onBindViewHolder(holder: Adapter.myViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(colorList[position].Colorname, context)
        }
        val data = colorList[position]
        holder.myColorImg.setBackgroundColor(data.Colorhex)
        holder.myTextView.text = data.Colorname
    }

}