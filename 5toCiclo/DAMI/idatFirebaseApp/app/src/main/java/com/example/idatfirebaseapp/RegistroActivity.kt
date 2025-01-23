package com.example.idatfirebaseapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idatfirebaseapp.databinding.ActivityRegistroBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegistroActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        binding.btnRegistrar.setOnClickListener{
            val nombres= binding.etNombres.text.toString()
            val apellidos= binding.etNombres.text.toString()
            val correo= binding.etCorreoReg.text.toString()
            val password= binding.etPasswordReg.text.toString()
            GuardarDataEmpleado(nombres, apellidos, correo)//guarda la data normal del usuario en la DB
            RegistrarEmpleado(correo, password)//Este es de seguridad, o sea, registra email y password
        }
    }

    private fun RegistrarEmpleado(correo: String, password: String) {
        auth.createUserWithEmailAndPassword(correo, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                }
                else {

                }
            }
    }

    private fun GuardarDataEmpleado(nombres: String, apellidos: String, correo: String) {
        TODO("Not yet implemented")
    }

}