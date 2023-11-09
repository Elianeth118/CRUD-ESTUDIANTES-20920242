package com.example.crud_estudiantes
import java.io.Serializable

class estudiante (numControl: String, nombre:String, apellidos: String, semestre:   String ):Serializable{
    val numControl: String = numControl
    var nombre: String = nombre
    var apellidos: String = apellidos
    var semestre: String = semestre


    companion object {
        private const val serialVersionUID: Long = 1
    }

    override fun toString(): String {
        return "NumControl: $numControl, Nombre: $nombre, Apellidos: $apellidos, Semestre: $semestre"
    }


}