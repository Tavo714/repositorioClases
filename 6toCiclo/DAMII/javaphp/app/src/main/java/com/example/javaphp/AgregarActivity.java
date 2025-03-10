package com.example.javaphp;

import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Calendar;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import android.Manifest;



public class AgregarActivity extends AppCompatActivity {
    EditText etDni, etNombre, etCorreo, etTelefono, etFecha, etLatitud, etLongitud;
    Button btnRegistrar, btnVolver;
    ImageView btnCalendario, btnUbicacion;
    RequestQueue requestQueue;
    private static final String URL_REGISTRO = "http://10.0.2.2/DAMII_java_php_mysql/registro.php"; // Para emulador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        etDni = findViewById(R.id.etDni);
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        etFecha = findViewById(R.id.etFecha);
        etLatitud = findViewById(R.id.etLatitud);
        etLongitud = findViewById(R.id.etLongitud);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolver = findViewById(R.id.btnVolver);
        btnCalendario = findViewById(R.id.btnCalendario);
        btnUbicacion = findViewById(R.id.btnUbicacion);

        requestQueue = Volley.newRequestQueue(this);

        btnCalendario.setOnClickListener(v -> mostrarDatePicker());
        btnRegistrar.setOnClickListener(v -> registrarUsuario());
        btnVolver.setOnClickListener(v -> finish());

        btnUbicacion.setOnClickListener(v -> {
            Log.d("DEBUG", "📍 Botón de ubicación presionado");
            obtenerUbicacion();
        });

    }

    private void mostrarDatePicker() {
        final Calendar calendario = Calendar.getInstance();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int día = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> etFecha.setText(year + "-" + (month + 1) + "-" + dayOfMonth),
                año, mes, día
        );
        datePickerDialog.show();
    }

    private void registrarUsuario() {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("dni", etDni.getText().toString().trim());
            jsonBody.put("nombre", etNombre.getText().toString().trim());
            jsonBody.put("correo", etCorreo.getText().toString().trim());
            jsonBody.put("telefono", etTelefono.getText().toString().trim());
            jsonBody.put("fecha", etFecha.getText().toString().trim());
            jsonBody.put("latitud", etLatitud.getText().toString().trim());
            jsonBody.put("longitud", etLongitud.getText().toString().trim());

            System.out.println("🔍 JSON ENVIADO: " + jsonBody.toString()); // LOG PARA VERIFICAR

            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST, URL_REGISTRO, jsonBody,
                    response -> {
                        System.out.println("✅ RESPUESTA DEL SERVIDOR: " + response.toString()); // LOG PARA VERIFICAR
                        try {
                            if (response.getString("status").equals("success")) {
                                Toast.makeText(AgregarActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                finish(); // Cierra la actividad después de registrar
                            } else {
                                Toast.makeText(AgregarActivity.this, "Error en el registro: " + response.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> {
                        error.printStackTrace();
                        Toast.makeText(AgregarActivity.this, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show();
                    }
            );

            requestQueue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void obtenerUbicacion() {
        Log.d("DEBUG", "📡 Iniciando obtención de ubicación...");

        // Verifica si los permisos de ubicación están habilitados (esto es necesario desde Android 6.0+)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Log.e("ERROR", "❌ Permisos de ubicación no concedidos");
            Toast.makeText(this, "Debe conceder permisos de ubicación", Toast.LENGTH_SHORT).show();
            return;
        }

        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        double lat = location.getLatitude();
                        double lon = location.getLongitude();
                        Log.d("DEBUG", "📍 Ubicación obtenida: " + lat + ", " + lon);
                        etLatitud.setText(String.valueOf(lat));
                        etLongitud.setText(String.valueOf(lon));
                    } else {
                        Log.e("ERROR", "❌ Ubicación no disponible");
                        Toast.makeText(this, "No se pudo obtener la ubicación", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e("ERROR", "❌ Error al obtener la ubicación: " + e.getMessage());
                    Toast.makeText(this, "Error al obtener la ubicación", Toast.LENGTH_SHORT).show();
                });
    }



    private void limpiarCampos() {
        etDni.setText("");
        etNombre.setText("");
        etCorreo.setText("");
        etTelefono.setText("");
        etFecha.setText("");
        etLatitud.setText("");
        etLongitud.setText("");
    }


}

