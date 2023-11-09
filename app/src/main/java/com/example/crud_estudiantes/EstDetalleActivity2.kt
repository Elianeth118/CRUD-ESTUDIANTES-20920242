package com.example.crud_estudiantes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EstDetalleActivity2 : AppCompatActivity() {
    lateinit var txtDetalle: TextView
    lateinit var btnEditar:Button
    lateinit var btnEliminar:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_est_detalle2)

        txtDetalle=findViewById(R.id.contenidoDetalle)
        btnEditar=findViewById(R.id.btnEditar)


        val est = intent.getSerializableExtra("Estudiante") as estudiante

        val contenido ="Estudiante encontrado:\n"+
                ".NC: ${est.numControl}  " +
                "Nombre: ${est.nombre}  " +
                "Apelidos: ${est.apellidos}  " +
                "Semestre: ${est.semestre} " +
                "\n------------------------------------------------------------\n"
        txtDetalle.text = contenido

        btnEditar.setOnClickListener {
            val intEditar = Intent(this, EditarActivity::class.java)
            intEditar.putExtra("Estudiante", est)
            startActivity(intEditar)
        }


    }
}