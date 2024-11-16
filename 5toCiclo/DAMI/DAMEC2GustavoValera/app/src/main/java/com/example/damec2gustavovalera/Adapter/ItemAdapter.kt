package com.example.damec2gustavovalera.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.damec2gustavovalera.Model.Empleado
import com.example.damec2gustavovalera.R

class ItemAdapter(private val context: Context, private val empleados: List<Empleado>) : BaseAdapter() {

    override fun getCount(): Int {
        return empleados.size
    }

    override fun getItem(position: Int): Empleado {
        return empleados[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_empleado, parent, false)
        val empleado = getItem(position)
        val nombreCompleto = "${empleado.nombre} ${empleado.apellido}"
        val nombreTextView = view.findViewById<TextView>(R.id.tvNombreEmpleado)
        nombreTextView.text = nombreCompleto

        return view
    }
}
