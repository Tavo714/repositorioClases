package com.example.sistemalogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistemalogin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var usuario: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        usuario= intent.getStringExtra("username").toString()
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvSaludo.setText("Hola "+ usuario)
        binding.ivCerrar.setOnClickListener{
            AlertaCierre()
        }
    }

    private fun AlertaCierre() {
        var alerta = AlertDialog.Builder(this)
        alerta.setTitle("Alerta de Cierre - Sistema Empleados")
        alerta.setMessage("Esta segur@ de que desea salir?")
        alerta.setCancelable(false)
        alerta.setPositiveButton("Si"){
            dialog, which->CerrarSesion()
        }
        alerta.setNegativeButton("No"){
            dialog, which ->
        }
        alerta.show()
    }

    private fun CerrarSesion(){
        BorrarSesion()
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun BorrarSesion() {
        var sharedPreferences= getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.remove("nombreUser")
        editor.commit()
    }
}