package com.ciudadpeet.demo

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class FavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)


        val perritosFavoritos = listOf(

            Perrito("Luna", "S/ 50 x fin de semana", "Miraflores", R.mipmap.ic_launcher),
            Perrito("Kira", "S/ 25 x tarde", "Lince", R.mipmap.ic_launcher)
        )


        val lvFavoritos = findViewById<ListView>(R.id.lvFavoritos)
        val adaptador = PerritoAdapter(this, perritosFavoritos)
        lvFavoritos.adapter = adaptador
    }
}