package com.example.javaphp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EliminarClienteDialog extends DialogFragment {
    private static final String URL_ELIMINAR = "http://10.0.2.2/DAMII_java_php_mysql/eliminar.php";
    private final String dni, nombre, correo, telefono, fecha;

    public EliminarClienteDialog(String dni, String nombre, String correo, String telefono, String fecha) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirmar Eliminación")
                .setMessage("¿Seguro que quieres eliminar este cliente?\n\n"
                        + "DNI: " + dni + "\n"
                        + "Nombre: " + nombre + "\n"
                        + "Correo: " + correo + "\n"
                        + "Teléfono: " + telefono + "\n"
                        + "Fecha: " + fecha)
                .setPositiveButton("Eliminar", (dialog, which) -> eliminarCliente())
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());

        return builder.create();
    }

    private void eliminarCliente() {
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());

        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("dni", dni);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.DELETE, URL_ELIMINAR, jsonBody,
                    response -> {
                        Toast.makeText(getContext(), "Cliente eliminado correctamente", Toast.LENGTH_SHORT).show();
                        requireActivity().finish(); // Cierra la actividad actual y regresa a la lista
                    },
                    error -> Toast.makeText(getContext(), "Error al eliminar cliente", Toast.LENGTH_SHORT).show());

            requestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
