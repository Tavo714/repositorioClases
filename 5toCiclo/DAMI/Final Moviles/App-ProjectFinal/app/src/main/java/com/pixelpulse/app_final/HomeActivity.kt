package com.pixelpulse.app_final

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.pixelpulse.app_final.Model.Opciones
import com.pixelpulse.app_final.adapter.itemAdapterOpciones
import com.pixelpulse.app_final.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterOpciones: itemAdapterOpciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Redirigir al LoginActivity si no hay usuario autenticado
        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Configuración de ViewBinding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView
        val opciones = listOf(
            Opciones(R.drawable.trabajadores_icon, "Trabajadores"),
            Opciones(R.drawable.lista_a, "Ingreso de Personal")
        )

        adapterOpciones = itemAdapterOpciones(this, opciones) { opcion ->
            when (opcion.opcion) {
                "Trabajadores" -> abrirTrabajadores()
                "Ingreso de Personal" -> abrirRegistrarAsistencia()
            }
        }

        binding.listaOpciones.layoutManager = LinearLayoutManager(this)
        binding.listaOpciones.adapter = adapterOpciones

        // Botón para cerrar sesión
        binding.btnCerrarSesion.setOnClickListener {
            cerrarSesion()
        }
    }

    private fun abrirRegistrarAsistencia() {
        val intent = Intent(this, RegistrarAsistenciaActivity::class.java)
        startActivity(intent)
    }

    private fun abrirTrabajadores() {
        val intent = Intent(this, TrabajadoresActivity::class.java)
        startActivity(intent)
    }

    private fun cerrarSesion() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}

