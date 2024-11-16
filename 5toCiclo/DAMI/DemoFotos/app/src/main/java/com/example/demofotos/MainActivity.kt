package com.example.demofotos

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demofotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val pickMedia= registerForActivityResult(PickVisualMedia()){ uri->
        if(uri != null){
            //Imagen de la galeria fue seleccionada
            binding.ivFoto.setImageURI(uri)
        }
        else{
            //Imagen no fue seleccionada
        }
    }
    lateinit var binding: ActivityMainBinding
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
        binding.btnTomarFoto.setOnClickListener{
            ValidarPermisos()
        }
        binding.btnFotoGaleria.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
    }
    private fun ValidarPermisos(){
        val estaPermitido= PackageManager.PERMISSION_GRANTED
        val permisoDeseado= ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        if(permisoDeseado!=estaPermitido){
            SolicitarPermiso()
        }
        else{
            AbrirCamara()
        }
    }

    private fun SolicitarPermiso(){
        val solicitud= ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)
        if(solicitud)
        //el usuario ya ha cancelado o denegado el permiso.
        {
            Toast.makeText(this, "Ud. Cancelo el permiso, para activarlo hagalo manualmente", Toast.LENGTH_LONG).show()
        }
        else
        //pedir permiso
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 100)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100){
            if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //Permiso aceptado
            }
            else{
                //Permiso denegado
            }
        }
    }

    private fun AbrirCamara(){
        val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode== RESULT_OK) {
            val foto: Bitmap = data!!.extras!!.get("data") as Bitmap
            binding.ivFoto.setImageBitmap(foto)
        }
    }
}