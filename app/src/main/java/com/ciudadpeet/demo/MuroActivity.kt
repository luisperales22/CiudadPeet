package com.ciudadpeet.demo

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MuroActivity : AppCompatActivity() {

    val perritos = arrayOf(
        "Boby - S/ 30 x día - San Juan de Lurigancho",
        "Luna - S/ 50 x fin de semana - Miraflores",
        "Max - S/ 15 x paseo - Surco",
        "Rocky - S/ 40 x día - San Isidro",
        "Kira - S/ 25 x tarde - Lince"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.muroactivity)


        val lvMascotas = findViewById<ListView>(R.id.lvMascotas)



        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, perritos)
        lvMascotas.adapter = adaptador


        lvMascotas.setOnItemClickListener { parent, view, position, id ->

            // Viajamos a la Pantalla de Detalles
            val intent = Intent(this, DetalleActivity::class.java)
            startActivity(intent)
        }
    }
}