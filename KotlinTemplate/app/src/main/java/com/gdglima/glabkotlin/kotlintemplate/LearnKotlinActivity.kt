package com.gdglima.glabkotlin.kotlintemplate

import com.google.android.gms.ads.InterstitialAd
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView

                            //herencia e implementación de interfaces
class LearnKotlinActivity : AppCompatActivity(), View.OnClickListener {


    private val LOG_TAG="LearnKotlinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_kotlin)
        val miboton=findViewById(R.id.btn_sentencia) as Button

        miboton.setOnClickListener(this)
        findViewById(R.id.btn_safety_null).setOnClickListener(this)
        findViewById(R.id.btn_destructuring).setOnClickListener(this)
        findViewById(R.id.btn_lambdas).setOnClickListener(this)



        Snackbar.make(findViewById(R.id.container),"Bienvenido a Kotlin",Snackbar.LENGTH_LONG).show()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_learn_kotlin, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }


    //recibir los eventos de click
    override fun onClick(button: View) {
        when(button.id){
            R.id.btn_sentencia -> mayorDeDosNumeros(5,11)
            R.id.btn_safety_null -> safetyNull()
            R.id.btn_destructuring -> destructuring()
            R.id.btn_lambdas->lambdas()
        }
    }

    //métodos
    //<EJEMPLOS>
    //sentencias como expresiones
    fun mayorDeDosNumeros(a:Int,b:Int){
        //las sentencias retornarán valores a la variable
        val mayor=if(a>b)a else b
        val resultadoTexto="el mayor entre $a y $b  es $mayor"
        alert(resultadoTexto)
        Log.d(LOG_TAG,resultadoTexto)
    }

    //ejemplo de la característica de evasión para lo Null Pointer Exception de java
    fun safetyNull(){
        //menciono que juan será instancia de
        //DangerousPerson pero a su vez podrá recibir null
        var juan:DangerousPerson?= DangerousPerson(null,"Torres")
                                                //(nombres,apellidos)
        Validador.textoResultados=""
        //imprimo el nombre de juan, pero este es null
        Validador.imprimirNombres(juan)
        //asigno recién el nombre de juan
        juan?.nombres="Juan"
        //imprimo el nombre de juan, ahora sí existe
        Validador.imprimirNombres(juan)

        //imprimo el telefono de juan, pero este es null
        Validador.imprimirTelefono(juan)
        //asigno una instancia de DangerousPhone
        juan?.telefono= DangerousPhone("5555-5555","51")
        //imprimo el telefono de juan, ahora sí existe
        Validador.imprimirTelefono(juan)

        //asigno null al objeto base, juan ya no existe
        juan=null
        Validador.imprimirTelefono(juan)

        alert(Validador.textoResultados)
    }

    //ejemplo de desestructuran o desmenusar los atributos de un objeto en diferentes variables
    fun destructuring(){

        val carlos=Person("Carlos","Chavez","123456789")

        //desestructurando atributos de la clase persona
        val (nombres,apellidos,dni)=carlos

        //imprime cada uno de ellos de manera independiente como variable en el texto
        val resultadoTexto="hola mi nombre es $nombres $apellidos y mi dni es $dni"
        Log.d(LOG_TAG,resultadoTexto)
        alert(resultadoTexto)
    }

    //ejemplo de como pasar lambda a una funcion cualquiera
    fun lambdas(){
        ejecuta({
            Log.d(LOG_TAG,"hola desde aquí")
            alert("hola desde aquí")
        })
    }
        //esta función ejecuta una función que recibe por parámetro
        fun ejecuta(funcion: ()->Unit){
            funcion()
        }

    //</EJEMPLOS>


    //mostrar mensaje en pantalla
    fun alert(message:String){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("GLAB")
               .setMessage(message)
                .setPositiveButton("ok") { p0, p1 ->
                    p0.dismiss()
                }
        builder.create().show()
    }

}
