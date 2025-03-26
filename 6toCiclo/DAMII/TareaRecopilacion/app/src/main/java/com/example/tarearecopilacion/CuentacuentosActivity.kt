package com.example.tarearecopilacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class CuentacuentosActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contentView = layoutInflater.inflate(R.layout.activity_cuentacuentos, null)
        setContentView(contentView)

        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            startActivity(Intent(this, CurriculumActivity::class.java))
        }
    }
}
