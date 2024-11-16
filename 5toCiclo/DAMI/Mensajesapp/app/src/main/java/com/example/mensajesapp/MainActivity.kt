package com.example.mensajesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mensajesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //antes para usar o acceder a los elementos XML de mi activity
    //tenia que declarar variables del mismo tipo de los elementos que estan
    //en mi activity.

    // ej: lateinit var cajaNombres: EditText

    //La manera actual es usar una Directiva en el archivo de configuracion
    //llamada BuildFeatures

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //paso 2:
        binding= ActivityMainBinding.inflate(layoutInflater)
        //paso 3, modificar la sgte linea:
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //llamada
        binding.btnSaludar.setOnClickListener{
            var nombreIngresado = binding.etNombre.text
            if(nombreIngresado.equals("") || nombreIngresado.isEmpty())
                //binding.tvSaludo.setText("Ingrese un nombre")
                Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show()
            else
                binding.tvSaludo.setText("Hola "+nombreIngresado.toString())
        }

    }
}