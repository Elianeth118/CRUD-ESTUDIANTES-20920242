package com.example.crud_estudiantes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditarActivity : AppCompatActivity() {
    lateinit var txtViewControl:TextView
    lateinit var editNombre: EditText
    lateinit var editApellido: EditText
    lateinit var editSemestre: EditText
    lateinit var btnGuardarEditar: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        txtViewControl=findViewById(R.id.ViewNumControl)
        editNombre=findViewById(R.id.ediatrNombre)
        editApellido=findViewById(R.id.editarApellidos)
        editSemestre=findViewById(R.id.editarSemestre)
        btnGuardarEditar=findViewById(R.id.btnEditGuardar)


        val est = intent.getSerializableExtra("Estudiante") as estudiante
        val contenido ="Datos actuales:\n"+
                ".NC: ${est.numControl}  " +
                "Nombre: ${est.nombre}  " +
                "Apelidos: ${est.apellidos}  " +
                "Semestre: ${est.semestre} " +
                "\n------------------------------------------------------------\n"
        txtViewControl.text = contenido
        editNombre.setText(est.nombre)
        editApellido.setText(est.apellidos)
        editSemestre.setText(est.semestre)

        btnGuardarEditar.setOnClickListener {
            val nombreNuevo = editNombre.text.toString()
            val apellidosNuevo = editApellido.text.toString()
            val semestreNuevo = editSemestre.text.toString()
            est.nombre = nombreNuevo
            est.apellidos = apellidosNuevo
            est.semestre = semestreNuevo
            val contenido = "Datos actualizados:\n" +
                    ".NC: ${est.numControl}  " +
                    "Nombre: ${est.nombre}  " +
                    "Apelidos: ${est.apellidos}  " +
                    "Semestre: ${est.semestre} " +
                    "\n------------------------------------------------------------\n"
            txtViewControl.text = contenido
        }


    }
}