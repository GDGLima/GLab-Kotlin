package com.gdglima.glabkotlin.kotlintemplate

import android.util.Log

/**
 * Created by Carlos on 13-sep-17.
 */

//clase telefono peligroso
class DangerousPhone(var numero:String,var postal:String)

//clase persona peligrosa por ser nulleable
class DangerousPerson constructor(var nombres:String?,var apellidos:String){
    var telefono:DangerousPhone?=null
    init{
        //aca se ejecuta código (si es necesario) del constructor
    }
}

//clase persona segura por NO ser nulleable
data class Person(var nombres:String,var apellidos:String,var dni:String)

//Singleton que me imprime los datos de una persona en "peligro de null"
object Validador{
    val LOG_TAG="LearnKotlinActivity"//filtren el log por este nombre
    var textoResultados:String=""

    //Uso de operador de Elvis ?:
    //imprime solo el nombre de una persona
    fun imprimirNombres(persona:DangerousPerson?){
        //solo si la persona NO es null y el nombre TAMPOCO es null, imprimir el nombre de la persona.
        //Por otro lado, se imprime el texto alternativo
        val textoResultado=persona?.nombres ?: "la persona o sus datos no existen"
        Log.d(LOG_TAG, textoResultado)

        //concadenar a una variable que recolecte todos los logs
        textoResultados+="$textoResultado \n"
    }

    fun imprimirTelefono(persona:DangerousPerson?){
        //si la persona NO es null, tampoco el telefono , se imprime el numero telefónico de la persona.
        //Por otro lado, se imprime el texto alternativo
        val textoResultado=persona?.telefono?.numero ?: "la persona o sus datos de telefono no existen"
        Log.d(LOG_TAG, textoResultado)

        //concadenar a una variable que recolecte todos los logs
        textoResultados+="$textoResultado \n"
    }
}