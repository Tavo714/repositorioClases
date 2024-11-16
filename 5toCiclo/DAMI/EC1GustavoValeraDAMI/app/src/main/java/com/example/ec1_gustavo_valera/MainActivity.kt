package com.example.ec1_gustavo_valera

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ec1_gustavo_valera.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegistrar.setOnClickListener {

            val nombres = binding.etNombres.text.toString().trim()
            val dni = binding.etDni.text.toString().trim().toIntOrNull()


            val producto1 = binding.etProducto1.text.toString().trim()
            val precioProducto1 = binding.etPrecioProducto1.text.toString().trim().toDoubleOrNull()

            val producto2 = binding.etProducto2.text.toString().trim()
            val precioProducto2 = binding.etPrecioProducto2.text.toString().trim().toDoubleOrNull()

            val producto3 = binding.etProducto3.text.toString().trim()
            val precioProducto3 = binding.etPrecioProducto3.text.toString().trim().toDoubleOrNull()


            if (nombres.isEmpty()) {
                Toast.makeText(this, "El campo Nombres no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (dni == null || dni.toString().length != 8) {
                Toast.makeText(this, "Por favor, ingresa un DNI válido de 8 dígitos", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (producto1.isEmpty() || precioProducto1 == null) {
                Toast.makeText(this, "Por favor, ingresa el Producto 1 y un precio válido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (producto2.isEmpty() || precioProducto2 == null) {
                Toast.makeText(this, "Por favor, ingresa el Producto 2 y un precio válido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (producto3.isEmpty() || precioProducto3 == null) {
                Toast.makeText(this, "Por favor, ingresa el Producto 3 y un precio válido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, PantallaPago::class.java).apply {
                putExtra("nom", nombres)
                putExtra("dni", dni)
                putExtra("producto1", producto1)
                putExtra("precioProducto1", precioProducto1)
                putExtra("producto2", producto2)
                putExtra("precioProducto2", precioProducto2)
                putExtra("producto3", producto3)
                putExtra("precioProducto3", precioProducto3)
            }
            startActivity(intent)
        }
    }
}
