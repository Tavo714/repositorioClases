package com.example.tarearecopilacion

import android.content.Intent
import android.os.Bundle
import android.widget.*

class PlanillaActivity : DrawerBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = layoutInflater.inflate(R.layout.activity_planilla, null)
        setContentView(contentView)

        val etEmpleado = findViewById<EditText>(R.id.etEmpleado)
        val etHoras = findViewById<EditText>(R.id.etHoras)
        val etTarifa = findViewById<EditText>(R.id.etTarifa)

        val tvEmpleadoIngresado = findViewById<TextView>(R.id.tvEmpleadoIngresado)
        val tvTotalHoras = findViewById<TextView>(R.id.tvTotalHoras)
        val tvTotalTarifa = findViewById<TextView>(R.id.tvTotalTarifa)
        val tvTotalSueldoBruto = findViewById<TextView>(R.id.tvTotalSueldoBruto)
        val tvTotalEssalud = findViewById<TextView>(R.id.tvTotalEssalud)
        val tvTotalAFP = findViewById<TextView>(R.id.tvTotalAFP)
        val tvTotalSueldoNeto = findViewById<TextView>(R.id.tvTotalSueldoNeto)

        findViewById<Button>(R.id.btnProcesar).setOnClickListener {
            val nombre = etEmpleado.text.toString()
            val horas = etHoras.text.toString().toDoubleOrNull() ?: 0.0
            val tarifa = etTarifa.text.toString().toDoubleOrNull() ?: 0.0

            val sueldoBruto = horas * tarifa
            val descuentoEssalud = sueldoBruto * 0.12
            val descuentoAFP = sueldoBruto * 0.10
            val sueldoNeto = sueldoBruto - descuentoEssalud - descuentoAFP

            tvEmpleadoIngresado.text = nombre
            tvTotalHoras.text = "%.2f".format(horas)
            tvTotalTarifa.text = "%.2f".format(tarifa)
            tvTotalSueldoBruto.text = "%.2f".format(sueldoBruto)
            tvTotalEssalud.text = "%.2f".format(descuentoEssalud)
            tvTotalAFP.text = "%.2f".format(descuentoAFP)
            tvTotalSueldoNeto.text = "%.2f".format(sueldoNeto)
        }

        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            etEmpleado.text.clear()
            etHoras.text.clear()
            etTarifa.text.clear()
            tvEmpleadoIngresado.text = ""
            tvTotalHoras.text = ""
            tvTotalTarifa.text = ""
            tvTotalSueldoBruto.text = ""
            tvTotalEssalud.text = ""
            tvTotalAFP.text = ""
            tvTotalSueldoNeto.text = ""
        }

        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            startActivity(Intent(this, CurriculumActivity::class.java))
        }
    }
}
