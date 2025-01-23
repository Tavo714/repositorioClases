package com.pixelpulse.app_final.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pixelpulse.app_final.Model.Opciones
import com.pixelpulse.app_final.R

class itemAdapterOpciones(
    private val context: Context,
    private val opciones: List<Opciones>,
    private val onItemClick: (Opciones) -> Unit // Listener para clics
) : RecyclerView.Adapter<itemAdapterOpciones.OpcionesViewHolder>() {

    class OpcionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgOpcion: ImageView = itemView.findViewById(R.id.imgOpcion)
        val txtOpcion: TextView = itemView.findViewById(R.id.Opcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpcionesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.lista_opciones, parent, false)
        return OpcionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: OpcionesViewHolder, position: Int) {
        val opcion = opciones[position]
        holder.txtOpcion.text = opcion.opcion
        holder.imgOpcion.setImageResource(opcion.imgOpcion)
        holder.itemView.setOnClickListener { onItemClick(opcion) }
    }

    override fun getItemCount(): Int = opciones.size
}
