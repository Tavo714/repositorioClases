package com.example.validaredittext

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.validaredittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //1.
    lateinit var binding: ActivityMainBinding
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //
        enableEdgeToEdge()
        //3.
        setContentView(binding.root)
        //setContentView(R.layout.activity_main) <-Este es el original. Se modifica como esta arriba.
        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //4.
        binding.btnIngresar.setOnClickListener{
            var nombre= binding.etNombres.text.toString()
            var edadStr= binding.etEdad.text.toString()
            //Buenas practicas: crear mensaje para llamar el error.
            //Ruta mensaje: res/values/strings.xml
            var mensaje= getString(R.string.mensaje_caja_vacia)
            var iconoAlerta= AppCompatResources.getDrawable(this, R.drawable.error_et)
            if(iconoAlerta!=null){
                iconoAlerta.setBounds(0,0,80, 80)
            }
            if (nombre.isEmpty())
                binding.etNombres.setError(mensaje, iconoAlerta)
            if (edadStr.isEmpty())
                binding.etEdad.setError(mensaje)
        }
        //
    }
}