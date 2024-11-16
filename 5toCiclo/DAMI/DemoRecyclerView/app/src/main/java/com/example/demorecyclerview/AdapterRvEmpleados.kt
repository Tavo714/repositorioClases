package com.example.demorecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRvEmpleados(val context: Context, val empleados: MutableList<Empleado>)
    :RecyclerView.Adapter<AdapterRvEmpleados.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRvEmpleados.ViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_carde_view_layout, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: AdapterRvEmpleados.ViewHolder, position: Int) {
        val item= empleados.get(position)
        holder.nomApeEmpleado.setText(item.nombre)
        holder.correo.setText(item.email)
        holder.telefono.setText(item.telefono)
        holder.foto.setImageResource(item.foto)

    }

    override fun getItemCount(): Int {
        return empleados.size
    }
    //Version resumida de getItemCount():
    //override fun getItemCount(): Int = empleados.size

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        val nomApeEmpleado= vista.findViewById<TextView>(R.id.tvNombres)
        val correo= vista.findViewById<TextView>(R.id.tvCorreo)
        val telefono= vista.findViewById<TextView>(R.id.tvTelefono)
        val foto= vista.findViewById<ImageView>(R.id.ivFoto)
    }

}

/* -----------CLASE PARA UN RECYCLER VIEW CON UNA LISTA DE STRINGS-------------
class AdapterRvEmpleados(val context: Context, val empleados: MutableList<String>)
    :RecyclerView.Adapter<AdapterRvEmpleados.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterRvEmpleados.ViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.item_empleados_layout, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: AdapterRvEmpleados.ViewHolder, position: Int) {
        val item= empleados.get(position)
        holder.nomApeEmpleado.setText(item)
        //holder.nomApeEmpleado.setText((position+1).toString()+" "+item)
        holder.nroEmpleado.setText((position+1).toString())
    }

    override fun getItemCount(): Int {
        return empleados.size
    }
    //Version resumida de getItemCount():
    //override fun getItemCount(): Int = empleados.size

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        val nomApeEmpleado= vista.findViewById<TextView>(R.id.tvEmpleado)
        val nroEmpleado= vista.findViewById<TextView>(R.id.tvNro)
    }

}
 */