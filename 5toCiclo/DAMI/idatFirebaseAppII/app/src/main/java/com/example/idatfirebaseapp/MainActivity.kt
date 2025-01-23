package com.example.idatfirebaseapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idatfirebaseapp.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        binding.tvRegistrarse.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
        binding.btnEntrar.setOnClickListener{
            val correo = binding.etCorreo.text.toString()
            val password = binding.etPassword.text.toString()
            Login(correo, password)
        }

    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, "ON START!!!", Toast.LENGTH_SHORT).show()
        val usuarioActual = auth.currentUser
        if (usuarioActual != null) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast.makeText(this, "ON DESTROY!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        //Toast.makeText(this, "ON STOP!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, "ON RESUME!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        //Toast.makeText(this, "ON RESTART!!!", Toast.LENGTH_SHORT).show()
    }


    private fun Login(correo: String, password: String) {
        auth.signInWithEmailAndPassword(correo, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        baseContext,
                        "Autenticacion fallida!!! Verifique su correo y contraseña",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }

    }
}