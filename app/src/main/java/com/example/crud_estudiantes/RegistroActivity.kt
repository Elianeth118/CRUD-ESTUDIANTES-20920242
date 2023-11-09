package com.example.crud_estudiantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    lateinit var editNumControl: EditText
    lateinit var  editNombre: EditText
    lateinit var editApellido: EditText
    lateinit var editSemestre: EditText
    lateinit var btnGuardar: Button
    lateinit var btnVerLista:Button
    lateinit var  btnVer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        editNumControl = findViewById(R.id.edNC)
        editNombre = findViewById(R.id.edNombre)
        editApellido = findViewById(R.id.edApellidos)
        editSemestre = findViewById(R.id.edSemestre)
        btnGuardar = findViewById(R.id.btnGuardarRegistro)
        btnVerLista=findViewById(R.id.btnVerLista)

        btnVer = findViewById(R.id.btnVerRegistro)
        val listaEstudiante = ArrayList<estudiante>()

        btnGuardar.setOnClickListener {
            val numeroControl = editNumControl.text.toString()
            val nombre = editNombre.text.toString()
            val apellido = editApellido.text.toString()
            val semestre = editSemestre.text.toString()
            if (numeroControl.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || semestre.isEmpty()) {
                Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Validando campos....", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Datos Guardados", Toast.LENGTH_LONG).show()

                editNumControl.setText("")
                editNombre.setText("")
                editApellido.setText("")
                editSemestre.setText("")
                val miEstudiante = estudiante(numeroControl, nombre, apellido, semestre)
                listaEstudiante.add(miEstudiante)


            }

        }
        btnVer.setOnClickListener {
            val numeroControl = editNumControl.text.toString()
            val nombre = editNombre.text.toString()
            val apellido = editApellido.text.toString()
            val semestre = editSemestre.text.toString()
            if (numeroControl.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || semestre.isEmpty()) {
                Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Validando campos....", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Datos Guardados", Toast.LENGTH_LONG).show()
                val miEstudiante = estudiante(numeroControl, nombre, apellido, semestre)
                listaEstudiante.add(miEstudiante)
                val int_perfil = Intent(this, ElementoActivity::class.java)
                int_perfil.putExtra("estudiante",miEstudiante)
                startActivity(int_perfil)

            }
        }
        btnVerLista.setOnClickListener {
            val int_lista= Intent(this,ListaActivity::class.java)
            int_lista.putExtra("lista",listaEstudiante)
            startActivity(int_lista)
        }
    }
}