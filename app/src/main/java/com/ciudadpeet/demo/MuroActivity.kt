package com.ciudadpeet.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


data class Perrito(val nombre: String, val tarifa: String, val distrito: String, val foto: Int)

class MuroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.muroactivity)


        val listaPerritos = listOf(
            Perrito("Boby", "S/ 30 x día", "San Juan de Lurigancho", R.mipmap.ic_launcher),
            Perrito("Luna", "S/ 50 x fin de semana", "Miraflores", R.mipmap.ic_launcher),
            Perrito("Max", "S/ 15 x paseo", "Surco", R.mipmap.ic_launcher),
            Perrito("Rocky", "S/ 40 x día", "San Isidro", R.mipmap.ic_launcher),
            Perrito("Kira", "S/ 25 x tarde", "Lince", R.mipmap.ic_launcher)
        )


        val lvMascotas = findViewById<ListView>(R.id.lvMascotas)
        val adaptador = PerritoAdapter(this, listaPerritos)
        lvMascotas.adapter = adaptador


        lvMascotas.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetalleActivity::class.java)
            startActivity(intent)
        }


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavPeet)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_muro -> true
                R.id.nav_mensajes -> {
                    startActivity(Intent(this, MensajesActivity::class.java))
                    true
                }
                R.id.nav_favoritos -> {
                    startActivity(Intent(this, FavoritosActivity::class.java))
                    true
                }
                R.id.nav_perfil -> {
                    startActivity(Intent(this, PerfilActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}


class PerritoAdapter(context: Context, private val perritos: List<Perrito>) : ArrayAdapter<Perrito>(context, 0, perritos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.item_perrito, parent, false)
        }

        val perritoActual = getItem(position)


        val tvNombre = view!!.findViewById<TextView>(R.id.tvNombrePerro)
        val tvTarifa = view.findViewById<TextView>(R.id.tvTarifaPerro)
        val tvDistrito = view.findViewById<TextView>(R.id.tvDistritoPerro)
        val imgFoto = view.findViewById<ImageView>(R.id.imgFotoPerro)


        tvNombre.text = perritoActual?.nombre
        tvTarifa.text = perritoActual?.tarifa
        tvDistrito.text = "📍 ${perritoActual?.distrito}"


        imgFoto.setImageResource(perritoActual?.foto ?: R.mipmap.ic_launcher)

        return view
    }
}