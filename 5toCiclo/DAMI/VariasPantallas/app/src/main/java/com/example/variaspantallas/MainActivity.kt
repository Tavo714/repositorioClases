package com.example.variaspantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.variaspantallas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //1.
    lateinit var binding: ActivityMainBinding
    //1f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //2.
        binding= ActivityMainBinding.inflate(layoutInflater)
        //2f
        enableEdgeToEdge()
        //3.
        setContentView(binding.root)
        //3f
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //4.
        binding.btnIngresar.setOnClickListener{
            //Para pasar de esta activity a otra se usan intenciones Intents
            //5.
            var nombres = binding.etNombres.text.toString()
            var edad: Int= binding.etEdad.text.toString().toInt()
            //5f
            val intent = Intent(this, Pantalla2Activity::class.java)
            //6.
            var bundle= intent.putExtra("nom", nombres)
            bundle=intent.putExtra("ed", edad)
            //6f
            startActivity(intent)
        }
        //4f
    }
}