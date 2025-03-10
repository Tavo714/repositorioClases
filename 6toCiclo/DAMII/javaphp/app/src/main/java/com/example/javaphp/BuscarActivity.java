package com.example.javaphp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class BuscarActivity extends AppCompatActivity {
    EditText etDniBuscar;
    Button btnBuscar, btnEditar, btnEliminar, btnVolver;
    TextView tvResultado;
    RequestQueue requestQueue;

    private static final String URL_BUSCAR = "http://10.0.2.2/DAMII_java_php_mysql/buscar.php?dni=";

    String dniEncontrado, nombre, correo, telefono, fecha, latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        etDniBuscar = findViewById(R.id.etDniBuscar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnVolver = findViewById(R.id.btnVolverBuscar);
        tvResultado = findViewById(R.id.tvResultado);

        requestQueue = Volley.newRequestQueue(this);

        btnBuscar.setOnClickListener(v -> buscarCliente());
        btnEditar.setOnClickListener(v -> editarCliente());
        btnEliminar.setOnClickListener(v -> mostrarConfirmacionEliminar());
        btnVolver.setOnClickListener(v -> finish());
    }

    private void buscarCliente() {
        String dni = etDniBuscar.getText().toString().trim();

        if (dni.isEmpty()) {
            Toast.makeText(this, "Ingrese un DNI", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = URL_BUSCAR + dni;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        if (response.has("cliente")) {
                            JSONObject cliente = response.getJSONObject("cliente");

                            dniEncontrado = cliente.getString("dni");
                            nombre = cliente.getString("nombre");
                            correo = cliente.getString("correo");
                            telefono = cliente.getString("telefono");
                            fecha = cliente.getString("fecha_nacimiento");
                            latitud = cliente.getString("latitud");
                            longitud = cliente.getString("longitud");

                            tvResultado.setText(
                                    "DNI: " + dniEncontrado + "\n" +
                                            "Nombre: " + nombre + "\n" +
                                            "Correo: " + correo + "\n" +
                                            "Teléfono: " + telefono + "\n" +
                                            "Fecha: " + fecha + "\n" +
                                            "Latitud: " + latitud + "\n" +
                                            "Longitud: " + longitud);

                            tvResultado.setVisibility(View.VISIBLE);
                            btnEditar.setVisibility(View.VISIBLE);
                            btnEliminar.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(this, "Cliente no encontrado", Toast.LENGTH_SHORT).show();
                            tvResultado.setVisibility(View.GONE);
                            btnEditar.setVisibility(View.GONE);
                            btnEliminar.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(this, "Error al buscar cliente", Toast.LENGTH_SHORT).show());

        requestQueue.add(request);
    }

    private void editarCliente() {
        Intent intent = new Intent(this, EditarActivity.class);
        intent.putExtra("dni", dniEncontrado);
        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("telefono", telefono);
        intent.putExtra("fecha", fecha);
        intent.putExtra("latitud", latitud);
        intent.putExtra("longitud", longitud);
        startActivity(intent);
    }

    private void mostrarConfirmacionEliminar() {
        EliminarClienteDialog dialog = new EliminarClienteDialog(dniEncontrado, nombre, correo, telefono, fecha);
        dialog.show(getSupportFragmentManager(), "EliminarClienteDialog");
    }
}

