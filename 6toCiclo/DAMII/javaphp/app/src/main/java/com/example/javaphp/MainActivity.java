package com.example.javaphp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ClienteAdapter adapter;
    List<Cliente> clientes;
    RequestQueue requestQueue;
    Button btnAgregarCliente;  // BOTÓN PARA AGREGAR CLIENTE
    private static final String URL_LISTAR = "http://10.0.2.2/DAMII_java_php_mysql/listar.php"; // Para emulador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clientes = new ArrayList<>();
        adapter = new ClienteAdapter(clientes);
        recyclerView.setAdapter(adapter);
        requestQueue = Volley.newRequestQueue(this);

        btnAgregarCliente = findViewById(R.id.btnAgregarCliente); // VINCULAR BOTÓN
        btnAgregarCliente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AgregarActivity.class);
            startActivity(intent);
        });

        listarClientes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listarClientes(); // Cargar la lista nuevamente al regresar
    }




    private void listarClientes() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, URL_LISTAR, null,
                response -> {
                    clientes.clear();
                    try {
                        JSONArray array = response.getJSONArray("clientes");
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject clienteJson = array.getJSONObject(i);
                            Cliente cliente = new Cliente(
                                    clienteJson.getString("dni"),
                                    clienteJson.getString("nombre"),
                                    clienteJson.getString("correo"),
                                    clienteJson.getString("telefono"),
                                    clienteJson.getString("fecha_nacimiento"),
                                    clienteJson.getString("latitud"),
                                    clienteJson.getString("longitud")
                            );
                            clientes.add(cliente);
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );

        requestQueue.add(request);
    }
}

