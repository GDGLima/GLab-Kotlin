package com.gdglima.glabkotlin.kotlintemplate

import android.util.Log

/**
 * Created by Carlos on 13-sep-17.
 */

class DangerousPhone(var numero:String,var postal:String)
class DangerousPerson (var nombres:String?,var apellidos:String?){
    var telefono:DangerousPhone?=null
    init{

    }
}
data class Person(var nombres:String,var apellidos:String,var dni:String)

object Validador{
    val LOG_TAG="LearnKotlinActivity"
    fun imprimirNombres(persona:DangerousPerson?){
        Log.d(LOG_TAG, persona?.nombres ?: "la persona o sus datos no existen")
    }

    fun imprimirTelefono(persona:DangerousPerson?){
        Log.d(LOG_TAG, persona?.telefono?.numero ?: "la persona o sus datos de telefono no existen")
    }
}