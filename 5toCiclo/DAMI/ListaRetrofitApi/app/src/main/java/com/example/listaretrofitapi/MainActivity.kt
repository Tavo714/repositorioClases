package com.example.listaretrofitapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listaretrofitapi.Model.Pais
import com.example.listaretrofitapi.Servicios.ApiCliente
import com.example.listaretrofitapi.Servicios.RetrofitHelper
import com.example.listaretrofitapi.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listaPaises: MutableList<Pais>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val apiPaises = RetrofitHelper.GetRetrofit().create(ApiCliente::class.java)
        // para el uso de corrutinas por la funcion suspendida

        listaPaises = mutableListOf()

        GlobalScope.launch {
            val respuesta = apiPaises.listarPaises()
            if (respuesta != null){
                listaPaises = respuesta.body()!!
            }
            var variable = listaPaises.get(0).Nombre
            Toast.makeText(baseContext, variable, Toast.LENGTH_LONG).show()
        }
    }
}