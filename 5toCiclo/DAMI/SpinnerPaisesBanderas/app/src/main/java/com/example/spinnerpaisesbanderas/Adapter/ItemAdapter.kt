package com.example.spinnerpaisesbanderas.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.spinnerpaisesbanderas.Model.Pais
import com.example.spinnerpaisesbanderas.R

class ItemAdapter (val context: Context, val Paises: MutableList<Pais>): BaseAdapter() {
    override fun getCount(): Int {
        return Paises.size
    }

    override fun getItem(position: Int): Any {
        return Paises.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater= LayoutInflater.from(context)
        val vista= inflater.inflate(R.layout.item_paises_layout, parent, false)
        val item= getItem(position) as Pais
        val bandera= vista.findViewById<ImageView>(R.id.ivBandera)
        val pais= vista.findViewById<TextView>(R.id.tvNombrePais)
        bandera.setImageResource(item.bandera)
        pais.setText(item.nombre)
        return vista
    }

}