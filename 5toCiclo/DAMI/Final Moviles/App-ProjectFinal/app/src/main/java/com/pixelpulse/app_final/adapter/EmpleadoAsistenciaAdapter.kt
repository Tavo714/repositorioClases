package com.pixelpulse.app_final.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pixelpulse.app_final.Model.Empleados
import com.pixelpulse.app_final.R

class EmpleadoAsistenciaAdapter(
    private val context: Context,
    private val empleados: MutableList<Empleados>,
    private val onCheckClick: (Empleados, (Boolean) -> Unit) -> Unit,
    private val onCancelCheckClick: (Empleados) -> Unit
) : RecyclerView.Adapter<EmpleadoAsistenciaAdapter.EmpleadoViewHolder>() {

    class EmpleadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPerfil: ImageView = itemView.findViewById(R.id.imgPerfil)
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombreEmpleado)
        val asistenciaSwitch: Switch = itemView.findViewById(R.id.switchAsistencia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_empleado, parent, false)
        return EmpleadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {
        val empleado = empleados[position]
        holder.txtNombre.text = "${empleado.nombre} ${empleado.apellido}"

        // Asignar una imagen de perfil fija
        holder.imgPerfil.setImageResource(R.drawable.perfil)

        // Configurar el estado del Switch
        holder.asistenciaSwitch.isChecked = empleado.asistenciaRegistrada

        // Listener para marcar o cancelar asistencia
        holder.asistenciaSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                onCheckClick(empleado) { success ->
                    if (!success) {
                        holder.asistenciaSwitch.isChecked = false // Revertir si falla
                    }
                }
            } else {
                onCancelCheckClick(empleado)
            }
        }
    }

    override fun getItemCount(): Int = empleados.size

    fun actualizarLista(nuevaLista: List<Empleados>) {
        empleados.clear()
        empleados.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}

