package com.example.ec1_gustavo_valera

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ec1_gustavo_valera.databinding.ActivityPantallaPagoBinding

class PantallaPago : AppCompatActivity() {

    lateinit var binding: ActivityPantallaPagoBinding
    lateinit var nombres: String
    var dni: Int = -1

    lateinit var producto1: String
    var precioProducto1: Double = 0.0

    lateinit var producto2: String
    var precioProducto2: Double = 0.0

    lateinit var producto3: String
    var precioProducto3: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPantallaPagoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nombres = intent.getStringExtra("nom").toString()
        dni = intent.getIntExtra("dni", -1)

        producto1 = intent.getStringExtra("producto1").toString()
        precioProducto1 = intent.getDoubleExtra("precioProducto1", 0.0)

        producto2 = intent.getStringExtra("producto2").toString()
        precioProducto2 = intent.getDoubleExtra("precioProducto2", 0.0)

        producto3 = intent.getStringExtra("producto3").toString()
        precioProducto3 = intent.getDoubleExtra("precioProducto3", 0.0)

        binding.tvSaludo.text = "Hola, $nombres"
        binding.tvDni.text = "DNI: $dni"

        binding.tvProducto1.text = producto1
        binding.tvPrecioProducto1.text = "S/ ${String.format("%.2f", precioProducto1)}"

        binding.tvProducto2.text = producto2
        binding.tvPrecioProducto2.text = "S/ ${String.format("%.2f", precioProducto2)}"

        binding.tvProducto3.text = producto3
        binding.tvPrecioProducto3.text = "S/ ${String.format("%.2f", precioProducto3)}"

        val total = precioProducto1 + precioProducto2 + precioProducto3
        val totalRedondeado = String.format("%.2f", total).toDouble()
        binding.tvTotal.text = "Total a pagar: S/ $totalRedondeado"

        val igvProducto1 = String.format("%.2f", precioProducto1 * 0.18).toDouble()
        val igvProducto2 = String.format("%.2f", precioProducto2 * 0.18).toDouble()
        val igvProducto3 = String.format("%.2f", precioProducto3 * 0.18).toDouble()

        val totalIgv = igvProducto1 + igvProducto2 + igvProducto3
        val totalIgvRedondeado = String.format("%.2f", totalIgv).toDouble()

        binding.tvIgv.text = "IGV: S/ $totalIgvRedondeado"

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
