package com.example.idatfirebaseapp


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idatfirebaseapp.databinding.ActivityRegistroBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class RegistroActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
        db = Firebase.firestore

        binding.btnRegistrar.setOnClickListener{
            val nombres = binding.etNombres.text.toString()
            val apellidos = binding.etApellidos.text.toString()
            val correo = binding.etCorreoReg.text.toString()
            val password = binding.etPasswordReg.text.toString()
            GuardarDataEmpleado(nombres, apellidos, correo)//Guarda la data normal del usuario en la bd
            RegistrarEmpleado(correo, password)//Este es de seguridad, o sea, registras email y password
        }
    }

    private fun RegistrarEmpleado(correo: String, password: String) {
        auth.createUserWithEmailAndPassword(correo, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val user2 = user
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                }
            }
    }

    private fun GuardarDataEmpleado(nombres: String, apellidos: String, correo: String) {
        // Create a new user with a first and last name
        val empleado = hashMapOf(
            "Nombres" to nombres,
            "Apellidos" to apellidos,
            "Correo" to correo
        )

// Add a new document with a generated ID
        db.collection("Empleado")
            .add(empleado)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(baseContext, "Usuario GUARDADO!!!", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(baseContext, e.message.toString(),Toast.LENGTH_LONG).show()
            }
    }
}