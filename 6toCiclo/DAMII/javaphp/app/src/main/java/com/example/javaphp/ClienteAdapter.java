package com.example.javaphp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {
    private final List<Cliente> clientes;
    private final Context context;

    public ClienteAdapter(Context context, List<Cliente> clientes) {
        this.context = context;
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
        holder.tvNombre.setText(cliente.getNombre());
        holder.tvDni.setText("DNI: " + cliente.getDni());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BuscarActivity.class);
            intent.putExtra("dni", cliente.getDni());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDni;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDni = itemView.findViewById(R.id.tvDni);
        }
    }
}
