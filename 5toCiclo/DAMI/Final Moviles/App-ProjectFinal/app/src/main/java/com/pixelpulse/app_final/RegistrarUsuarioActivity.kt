package com.pixelpulse.app_final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pixelpulse.app_final.databinding.ActivityRegistrarUsuarioBinding

class RegistrarUsuarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarUsuarioBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegistrar.setOnClickListener {
            val email = binding.edtCorreo.text.toString()
            val password = binding.edtContrasena.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Usuario creado exitosamente", Toast.LENGTH_SHORT).show()
                            // Redirigir al LoginActivity
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para volver al login sin crear un usuario
        binding.btnCancelar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
