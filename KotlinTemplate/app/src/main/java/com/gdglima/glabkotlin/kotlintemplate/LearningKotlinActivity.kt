package com.gdglima.glabkotlin.kotlintemplate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_learning_kotlin.*

class LearningKotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_kotlin)
        app();
    }

    private fun app() {
        button.setOnClickListener({
            Toast.makeText(this,"Acción",Toast.LENGTH_LONG).show()
        })
    }

    /*
     Aquí creo un objeto persona cuya función es aceptar parámetros ,que serán sus atributos, y
     crear un nombre completo a partir de este, luego puede crear una copia o clonación de la instancia
     ,el cual será el hijo de la persona, realizando solo modificaciones en el nombre mas no en el apellido.
     Además, notamos que el nombre completo es de solo lectura.
    */
/*Data class implementa Copy, ToString, Equals, HashCode*/
    data class Persona(var nombre:String,var apellido:String){
        var nombreCompleto:String=""
            private set(prop){field=prop}
            get(){return "$field "}
        init{
            nombreCompleto="$nombre $apellido"
        }
    }
/*
Demostración de la seguridad que demuestra kotlin al
momento de intentar crear una referencia a null
*/
//clase telefono
    class DangerousPhone(var numero:String,var postal:String)
    //clase persona
    class DangerousPerson constructor(var nombres:String?,var apellidos:String?){
        var telefono:DangerousPhone?=null
        init{
        }
    }
    //main
    fun main(args: Array<String>) {
        var juan:DangerousPerson? = DangerousPerson(null,"Torres")

        //mostrando datos personales
        imprimirNombres(juan)
        juan?.nombres="Juan"
        imprimirNombres(juan)

        //mostrando datos de teléfono
        imprimirTelefono(juan)
        juan?.telefono=DangerousPhone("5555-555","51")
        imprimirTelefono(juan)
        //mostrando datos de telefono de una persona que no existe (es null)
        juan=null
        imprimirTelefono(juan)

    }
    //imprime el nombre de una persona si existe
    fun imprimirNombres(persona:DangerousPerson?){
        println("${persona?.nombres ?:"la persona o sus datos no existian"}")
    }
    //imprime el telefono de una persona si existe
    fun imprimirTelefono(persona:DangerousPerson?){
        println("${persona?.telefono?.numero ?:"la persona o sus datos de telefono no existian"}")
    }
}
