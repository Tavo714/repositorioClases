package com.example.javaphp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {
    private List<Cliente> clientes;

    public ClienteAdapter(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cliente cliente = clientes.get(position);
        holder.tvDni.setText("DNI: " + cliente.getDni());
        holder.tvNombre.setText("Nombre: " + cliente.getNombre());
        holder.tvCorreo.setText("Correo: " + cliente.getCorreo());
        holder.tvTelefono.setText("Teléfono: " + cliente.getTelefono());
        holder.tvFecha.setText("Fecha: " + cliente.getFechaNacimiento());
        holder.tvLatitud.setText("Latitud: " + cliente.getLatitud());
        holder.tvLongitud.setText("Longitud: " + cliente.getLongitud());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDni, tvNombre, tvCorreo, tvTelefono, tvFecha, tvLatitud, tvLongitud;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDni = itemView.findViewById(R.id.tvDni);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCorreo = itemView.findViewById(R.id.tvCorreo);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvLatitud = itemView.findViewById(R.id.tvLatitud);
            tvLongitud = itemView.findViewById(R.id.tvLongitud);
        }
    }
}

