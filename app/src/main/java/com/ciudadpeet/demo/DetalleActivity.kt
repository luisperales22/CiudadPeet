package com.ciudadpeet.demo // ⚠️ Ojo: Revisa que coincida con tu paquete

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)


        val btnAceptar = findViewById<Button>(R.id.btnAceptarTrabajo)


        btnAceptar.setOnClickListener {

            Toast.makeText(this, "¡Felicidades! Has aceptado cuidar a Boby 🐶", Toast.LENGTH_LONG).show()


            finish()
        }
    }
}