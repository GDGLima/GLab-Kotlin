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
import kotlin.reflect.KFunction1


class LearnKotlinActivity : AppCompatActivity(), View.OnClickListener {


    private var mLevel: Int = 0
    private var mNextLevelButton: Button? = null
    private var mInterstitialAd: InterstitialAd? = null
    private var mLevelTextView: TextView? = null
    private val LOG_TAG="LearnKotlinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_kotlin)

        findViewById(R.id.btn_sentencia).setOnClickListener(this)
        findViewById(R.id.btn_safety_null).setOnClickListener(this)
        findViewById(R.id.btn_destructuring).setOnClickListener(this)
        findViewById(R.id.btn_lambdas).setOnClickListener(this)


        val nombre="Kotlin"
        Snackbar.make(findViewById(R.id.container),"Hola $nombre",Snackbar.LENGTH_LONG).show()
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


    override fun onClick(button: View?) {
        when(button?.id){
            R.id.btn_sentencia -> mayorDeDosNumeros(4,9)
            R.id.btn_safety_null -> safetyNull()
            R.id.btn_destructuring -> destructuring()
            R.id.btn_lambdas->lambdas()
        }
    }

    //métodos

    //sentencias como expresiones
    fun mayorDeDosNumeros(a:Int,b:Int){
        val mayor=if(a>b)a else b
        val resultadoTexto="el mayor de dos numeros es $mayor"
        alert(resultadoTexto)
        Log.d(LOG_TAG,resultadoTexto)
    }


    fun safetyNull(){
        var juan:DangerousPerson?= DangerousPerson(null,"Torres")
        Validador.imprimirNombres(juan)
        juan?.nombres="Juan"
        Validador.imprimirNombres(juan)

        Validador.imprimirTelefono(juan)
        juan?.telefono= DangerousPhone("5555-5555","51")
        Validador.imprimirTelefono(juan)

        juan=null
        Validador.imprimirTelefono(juan)
    }

    fun destructuring(){
        val carlos=Person("Carlos","Chavez","123456789")
        val (nombres,apellidos,dni)=carlos
        val resultadoTexto="hola mi nombre es $nombres $apellidos y mi dni es $dni"
        Log.d(LOG_TAG,resultadoTexto)
        alert(resultadoTexto)
    }

    fun lambdas(){
        ejecuta({ Log.d(LOG_TAG,"hola desde aquí") })
    }
        fun ejecuta(funcion: ()->Unit){
            funcion()
        }



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
