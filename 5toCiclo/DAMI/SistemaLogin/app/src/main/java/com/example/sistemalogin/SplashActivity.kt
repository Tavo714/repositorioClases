package com.example.sistemalogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Verificacion de si la user y pass estan guardados en el telefono
        var sharedPreferences=getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        var usuario= sharedPreferences.getString("nombreUser", "").toString()

        //1.
        Handler().postDelayed({
            if(usuario.isEmpty()){
                val intent= Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent= Intent(this, HomeActivity::class.java)
                intent.putExtra("username", usuario)
                startActivity(intent)
                finish()
            }
        }, 2000)
        //1f.
    }
}