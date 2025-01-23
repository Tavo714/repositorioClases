package com.pixelpulse.app_final.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pixelpulse.app_final.Model.Empleados
import com.pixelpulse.app_final.R

class EmpleadoAdapter(
    private val context: Context,
    private var empleados: List<Empleados>, // Cambiar a lista inmutable
    private val onViewClick: (Empleados) -> Unit,
    private val onEditClick: (Empleados) -> Unit,
    private val onDeleteClick: (Empleados) -> Unit
) : RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder>() {

    class EmpleadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPerfil: ImageView = itemView.findViewById(R.id.imgPerfil)
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombreEmpleado)
        val btnView: ImageView = itemView.findViewById(R.id.btnView)
        val btnEdit: ImageView = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_empleado_crud, parent, false)
        return EmpleadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {
        val empleado = empleados[position]
        holder.txtNombre.text = "${empleado.nombre} ${empleado.apellido}"

        // Configurar clics
        holder.btnView.setOnClickListener { onViewClick(empleado) }
        holder.btnEdit.setOnClickListener { onEditClick(empleado) }
        holder.btnDelete.setOnClickListener { onDeleteClick(empleado) }
    }

    override fun getItemCount(): Int = empleados.size

    fun actualizarLista(nuevaLista: List<Empleados>) {
        empleados = nuevaLista
        notifyDataSetChanged()
    }
}

