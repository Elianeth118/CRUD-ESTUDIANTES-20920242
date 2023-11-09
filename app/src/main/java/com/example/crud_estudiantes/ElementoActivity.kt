package com.example.crud_estudiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ElementoActivity : AppCompatActivity() {
    lateinit var txtDatos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elemento)

        txtDatos = findViewById(R.id.textPerfilesDatos)

        val est = intent.getSerializableExtra("estudiante") as estudiante
        txtDatos.text = est.toString()
    }
}