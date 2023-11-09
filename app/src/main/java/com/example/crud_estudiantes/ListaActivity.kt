package com.example.crud_estudiantes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ListaActivity : AppCompatActivity() {
    lateinit var txtRes: TextView
    lateinit var editBucar:EditText
    lateinit var btnBusca: Button
    lateinit var btnEliminar: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        txtRes=findViewById(R.id.textLista)
        editBucar=findViewById(R.id.editBuscar)
        btnBusca=findViewById(R.id.btnBucar)
        btnEliminar=findViewById(R.id.btnEliminar)
        val listaEstudiante = intent.getSerializableExtra("lista") as ArrayList<estudiante>

        var contenido = ""
        for (i in 0 until listaEstudiante.size) {
            val est = listaEstudiante[i]
            contenido += "Estudiante #${i + 1}" +"\n"+
                    ".NC: ${est.numControl}" +
                    "Nombre: ${est.nombre}" +
                    "Apelidos: ${est.apellidos}" +
                    "Semestre: ${est.semestre}" +
                    "\n------------------------------------------------------------\n"
        }
        txtRes.text = contenido


        btnBusca.setOnClickListener {
            val filtro = editBucar.text.toString()
            for (i in 0 until listaEstudiante.size) {
                val est = listaEstudiante[i]
                if(filtro == est.numControl){
                    Toast.makeText(this, "Alumno Encontrado", Toast.LENGTH_LONG).show()
                    val int_detalle= Intent(this,EstDetalleActivity2::class.java)
                    int_detalle.putExtra("Estudiante",est)
                    startActivity(int_detalle)
                }

            }
        }
        btnEliminar.setOnClickListener {
            val filtro = editBucar.text.toString()
            var i = 0
            while (i < listaEstudiante.size) {
                val est = listaEstudiante[i]
                if (filtro == est.numControl) {
                    Toast.makeText(this, "Alumno Encontrado", Toast.LENGTH_LONG).show()
                    listaEstudiante.removeAt(i)
                } else {
                    i++
                }
            }
            var contenido = ""
            for (i in 0 until listaEstudiante.size) {
                val est = listaEstudiante[i]
                contenido += "Estudiante #${i + 1}" + "\n" +
                        ".NC: ${est.numControl}" +
                        "Nombre: ${est.nombre}" +
                        "Apelidos: ${est.apellidos}" +
                        "Semestre: ${est.semestre}" +
                        "\n------------------------------------------------------------\n"
            }
            txtRes.text = contenido
        }


    }
}