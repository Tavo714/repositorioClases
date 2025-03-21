package com.example.javaphp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EditarActivity extends AppCompatActivity {
    EditText etNombre, etCorreo, etTelefono, etFecha, etLatitud, etLongitud;
    Button btnAceptar, btnCancelar;
    String dni;
    RequestQueue requestQueue;

    private static final String URL_EDITAR = Config.getServerURL() + "editar.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        etFecha = findViewById(R.id.etFecha);
        etLatitud = findViewById(R.id.etLatitud);
        etLongitud = findViewById(R.id.etLongitud);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);

        requestQueue = Volley.newRequestQueue(this);

        Intent intent = getIntent();
        dni = intent.getStringExtra("dni");
        etNombre.setText(intent.getStringExtra("nombre"));
        etCorreo.setText(intent.getStringExtra("correo"));
        etTelefono.setText(intent.getStringExtra("telefono"));
        etFecha.setText(intent.getStringExtra("fecha"));
        etLatitud.setText(intent.getStringExtra("latitud"));
        etLongitud.setText(intent.getStringExtra("longitud"));

        btnAceptar.setOnClickListener(v -> confirmarEdicion());
        btnCancelar.setOnClickListener(v -> finish());
    }

    private void confirmarEdicion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar Edición")
                .setMessage("¿Desea guardar los cambios?")
                .setPositiveButton("Sí", (dialog, which) -> actualizarCliente())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void actualizarCliente() {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("dni", dni);
            jsonBody.put("nombre", etNombre.getText().toString().trim());
            jsonBody.put("correo", etCorreo.getText().toString().trim());
            jsonBody.put("telefono", etTelefono.getText().toString().trim());
            jsonBody.put("fecha", etFecha.getText().toString().trim());
            jsonBody.put("latitud", etLatitud.getText().toString().trim());
            jsonBody.put("longitud", etLongitud.getText().toString().trim());

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, URL_EDITAR, jsonBody,
                    response -> Toast.makeText(this, "Cliente actualizado correctamente", Toast.LENGTH_SHORT).show(),
                    error -> Toast.makeText(this, "Error al actualizar cliente", Toast.LENGTH_SHORT).show());

            requestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
