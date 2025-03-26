package com.example.tarearecopilacion

import android.content.Intent
import android.os.Bundle
import android.widget.*

class ProgramaorActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = layoutInflater.inflate(R.layout.activity_programaor, null)
        setContentView(contentView)

        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val rbMasculino = findViewById<RadioButton>(R.id.rbMasculino)
        val rbFemenino = findViewById<RadioButton>(R.id.rbFemenino)
        val cbJunior = findViewById<CheckBox>(R.id.cbJunior)
        val cbIntermedio = findViewById<CheckBox>(R.id.cbIntermedio)
        val cbSenior = findViewById<CheckBox>(R.id.cbSenior)

        val tvNombres = findViewById<TextView>(R.id.tvResultadoNombresText)
        val tvEdad = findViewById<TextView>(R.id.tvResultadoEdadText)
        val tvSexo = findViewById<TextView>(R.id.tvResultadoSexoText)
        val tvSueldo = findViewById<TextView>(R.id.tvResultadoSueldoText)

        findViewById<Button>(R.id.btnCalcular).setOnClickListener {
            val nombres = etNombres.text.toString()
            val edad = etEdad.text.toString()
            val sexo = when {
                rbMasculino.isChecked -> "Masculino"
                rbFemenino.isChecked -> "Femenino"
                else -> "No especificado"
            }

            var sueldo = 0
            if (cbJunior.isChecked) sueldo += 1500
            if (cbIntermedio.isChecked) sueldo += 3000
            if (cbSenior.isChecked) sueldo += 5000

            tvNombres.text = nombres
            tvEdad.text = edad
            tvSexo.text = sexo
            tvSueldo.text = "S/ $sueldo"
        }

        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            etNombres.text.clear()
            etEdad.text.clear()
            rbMasculino.isChecked = false
            rbFemenino.isChecked = false
            cbJunior.isChecked = false
            cbIntermedio.isChecked = false
            cbSenior.isChecked = false
            tvNombres.text = ""
            tvEdad.text = ""
            tvSexo.text = ""
            tvSueldo.text = ""
        }

        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            startActivity(Intent(this, CurriculumActivity::class.java))
        }
    }
}
