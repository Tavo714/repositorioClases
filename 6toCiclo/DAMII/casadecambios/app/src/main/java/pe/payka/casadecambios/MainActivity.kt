package pe.payka.casadecambios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSoles = findViewById<EditText>(R.id.etSoles)
        val etDolares = findViewById<EditText>(R.id.etDolares)
        val etMarcos = findViewById<EditText>(R.id.etMarcos)
        val btnProcesar = findViewById<Button>(R.id.btnProcesar)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        val tvTotalSoles = findViewById<TextView>(R.id.tvTotalSoles)
        val tvTotalDolares = findViewById<TextView>(R.id.tvTotalDolares)
        val tvTotalMarcos = findViewById<TextView>(R.id.tvTotalMarcos)
        val tvTotalEuros = findViewById<TextView>(R.id.tvTotalEuros)

        btnProcesar.setOnClickListener {
            val soles = etSoles.text.toString().toDoubleOrNull() ?: 0.0
            val dolares = etDolares.text.toString().toDoubleOrNull() ?: 0.0
            val marcos = etMarcos.text.toString().toDoubleOrNull() ?: 0.0

            val solesAEuros = soles / 3.51 / 1.09
            val dolaresAEuros = dolares / 1.09
            val marcosAEuros = marcos / 2.12 / 1.09

            val totalEuros = solesAEuros + dolaresAEuros + marcosAEuros

            tvTotalSoles.text = "S/%.2f".format(soles)
            tvTotalDolares.text = "$%.2f".format(dolares)
            tvTotalMarcos.text = "%.2f DEM".format(marcos)
            tvTotalEuros.text = "%.2f Euros".format(totalEuros)
        }

        btnLimpiar.setOnClickListener {
            etSoles.text.clear()
            etDolares.text.clear()
            etMarcos.text.clear()
            tvTotalSoles.text = "S/0.00"
            tvTotalDolares.text = "$0.00"
            tvTotalMarcos.text = "0.00 DEM"
            tvTotalEuros.text = "0.00 Euros"
        }
    }
}
