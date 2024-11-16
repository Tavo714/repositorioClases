package com.example.variaspantallas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.variaspantallas.databinding.ActivityPantalla2Binding

class Pantalla2Activity : AppCompatActivity() {
    //1.
    lateinit var binding: ActivityPantalla2Binding
    //1f
    //6.
    lateinit var nombres: String
    var edad: Int=-1
    //6f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //5.
        nombres=intent.getStringExtra("nom").toString()
        edad= intent.getIntExtra("ed", -1).toInt()
        //5f
        //2.
        binding = ActivityPantalla2Binding.inflate((layoutInflater))
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
        //7.
        binding.tvNombres.setText("Bienvenid@ " + nombres)
        binding.tvEdad.setText("Tu edad es: " + edad.toString())
        //7f
        //4.
        binding.btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //4f
    }
}