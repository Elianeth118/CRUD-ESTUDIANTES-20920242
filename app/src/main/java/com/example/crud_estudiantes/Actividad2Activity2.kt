package com.example.crud_estudiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Actividad2Activity2 : AppCompatActivity() {
    lateinit var txt_name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad22)
        txt_name=findViewById(R.id.txtName)
        val nombreIntent = intent.getStringExtra("nombre")
        txt_name.text = nombreIntent


    }
}