package com.pixelpulse.app_final

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pixelpulse.app_final.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar ViewBinding
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de barras de sistema para pantalla completa
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Verificar si hay un usuario guardado
        val sharedPreferences = getSharedPreferences("loginData", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("nombre", "")

        // Redirigir después de 2 segundos
        Handler().postDelayed({
            if (user.isNullOrEmpty()) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username", user)
                startActivity(intent)
                finish()
            }
        }, 2000) // 2000 ms = 2 segundos
    }
}
