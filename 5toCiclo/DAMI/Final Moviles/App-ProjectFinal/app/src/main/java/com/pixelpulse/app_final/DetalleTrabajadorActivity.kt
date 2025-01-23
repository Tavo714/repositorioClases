package com.pixelpulse.app_final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pixelpulse.app_final.databinding.ActivityDetalleTrabajadorBinding

class DetalleTrabajadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleTrabajadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del Intent
        val nombre = intent.getStringExtra("trabajador_nombre") ?: "No disponible"
        val apellido = intent.getStringExtra("trabajador_apellido") ?: "No disponible"
        val puesto = intent.getStringExtra("trabajador_puesto") ?: "No disponible"
        val dni = intent.getStringExtra("trabajador_dni") ?: "No disponible"
        val fechNac = intent.getStringExtra("trabajador_fechNac") ?: "No disponible"
        val fechIng = intent.getStringExtra("trabajador_fechIng") ?: "No disponible"

        // Mostrar los datos en los campos correspondientes
        binding.txtDetalleNombre.setText(nombre)
        binding.txtDetalleApellido.setText(apellido)
        binding.txtDetallePuesto.setText(puesto)
        binding.txtDetalleDni.setText(dni)
        binding.txtDetalleFechaNacimiento.setText(fechNac)
        binding.txtDetalleFechaIngreso.setText(fechIng)

        // Botón para volver
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}


