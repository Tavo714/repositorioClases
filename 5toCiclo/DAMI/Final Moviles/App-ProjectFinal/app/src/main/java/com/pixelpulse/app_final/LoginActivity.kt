package com.pixelpulse.app_final

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pixelpulse.app_final.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnIngresar.setOnClickListener {
            val email = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            // Limpiar errores anteriores
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            if (validarCampos(email, password)) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        } else {
                            manejarErrores(task.exception?.message)
                        }
                    }
            }
        }

        binding.txtCrearUsuario.setOnClickListener {
            startActivity(Intent(this, RegistrarUsuarioActivity::class.java))
        }
    }

    private fun validarCampos(email: String, password: String): Boolean {
        var esValido = true

        if (email.isEmpty()) {
            binding.tilUsername.error = "El correo no puede estar vacío."
            esValido = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilUsername.error = "El formato del correo no es válido."
            esValido = false
        }

        if (password.isEmpty()) {
            binding.tilPassword.error = "La contraseña no puede estar vacía."
            esValido = false
        } else if (password.length < 6) {
            binding.tilPassword.error = "La contraseña debe tener al menos 6 caracteres."
            esValido = false
        }

        return esValido
    }

    private fun manejarErrores(error: String?) {
        when {
            error?.contains("password is invalid") == true -> {
                binding.tilPassword.error = "La contraseña es incorrecta."
            }
            error?.contains("no user record") == true -> {
                binding.tilUsername.error = "El correo electrónico no está registrado."
            }
            else -> {
                binding.tilUsername.error = "Credenciales incorrectas."
                binding.tilPassword.error = "Verifique el correo y la contraseña."
            }
        }
    }
}
