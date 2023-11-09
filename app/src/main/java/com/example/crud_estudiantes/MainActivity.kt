package com.example.crud_estudiantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txt_Act_title: TextView

    lateinit var btn_registra:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_Act_title = findViewById(R.id.txt_Act_title)

        btn_registra=findViewById(R.id.btn_Main_registro)



        btn_registra.setOnClickListener {
            val int_registra= Intent(this, RegistroActivity::class.java)
            startActivity(int_registra)
        }


    }
}