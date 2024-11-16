package com.example.sistemalogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sistemalogin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //1.
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnEntrar.setOnClickListener{
            var user= binding.etUser.text.toString()
            var pass= binding.etPassword.text.toString()

            if(user.isEmpty())
                binding.etUser.setError("Este dato es obligatorio")
            else{
                if(pass.isEmpty())
                    binding.etPassword.setError("Este dato es obligatorio")
                else{
                    if(user.equals("juan") && pass.equals("123")){
                        GuardarSesion(user)//guardar en telefono. Codigo al final.
                        val intent= Intent(this, HomeActivity::class.java)
                        intent.putExtra("username", user)
                        startActivity(intent)
                        finish()
                    }
                    else
                        Toast.makeText(this, "Usuario y/o clave incorrecto", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
//2. guardar usuario en memoria del telefono
    private fun GuardarSesion(user: String) {
        var sharedPreferences= getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        val editor= sharedPreferences.edit()
        editor.putString("nombreUser", user)
        editor.commit()
    }
}

