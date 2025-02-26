package com.example.tarearecopilacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class CurriculumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_curriculum)

        val cuentos: (Button) = findViewById(R.id.btnCuentos)
        cuentos.setOnClickListener {
            val intent = Intent(this, CuentacuentosActivity::class.java)
            startActivity(intent)
        }

        val cambios: (Button) = findViewById(R.id.btnCasaCambios)
        cambios.setOnClickListener {
            val intent = Intent(this, CasacambiosActivity::class.java)
            startActivity(intent)
        }

        val planillas: (Button) = findViewById(R.id.btnPlanillas)
        planillas.setOnClickListener {
            val intent = Intent(this, PlanillaActivity::class.java)
            startActivity(intent)
        }

        val programador: (Button) = findViewById(R.id.btnProgramador)
        programador.setOnClickListener {
            val intent = Intent(this, ProgramaorActivity::class.java)
            startActivity(intent)
        }

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        /* version con imagenes desde la web
        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))
        */

        imageList.add(SlideModel(R.drawable.androidstudio, "Para programar aplicaciones nativas Android", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.firebase, "Para tener un backend solido y con respaldo global", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.react, "Para desarrollo facil y reestructurable de proyectos web", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.angular, "Para desarrollo de Interfaces empresariales de alto nivel", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.tailwind, "Para un diseño web elegante en pocos pasos", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.java, "Para la construccion de un Backend solido y con soporte", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.springboot, "Para implementar capas de seguridad y excelente manejo de base de datos", ScaleTypes.FIT))



        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)


    }
}