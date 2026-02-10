package com.ciudadpeet.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnEntrar = findViewById<Button>(R.id.btnEntrar)


        btnEntrar.setOnClickListener {

            val intent = Intent(this, MuroActivity::class.java)
            startActivity(intent)
        }
    }
}