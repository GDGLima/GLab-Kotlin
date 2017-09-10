package com.gdglima.glabkotlin.gdglimaapp.helpers

/**
 * Created by emedinaa on 5/09/17.
 * Extensions
 * https://kotlinlang.org/docs/reference/extensions.html
 */

fun formatDate(value:String):String{
    val separate = value.split("/".toRegex())
    val year:String= separate[0]
    val month:String = separate[1]
    val day:String= separate[2]
    val sb = StringBuilder()
    sb.append(day).append(" ").append(monthByValue(month))
    return sb.toString()
}

fun monthByValue(month:String):String{
    when(month){
        "01"-> return "ENE"
        "02"-> return "FEB"
        "03"-> return "MAR"
        "04"-> return "ABR"
        "05"-> return "MAY"
        "06"-> return "JUN"
        "07"-> return "JUL"
        "08"-> return "AGO"
        "09"-> return "SEP"
        "10"-> return "OCT"
        "11"-> return "NOV"
        "12"-> return "DIC"
    }
    return ""
}

fun dateByValue(day:String):String{
    when(day){
        "01"-> "Lun"
        "02"-> "Mar"
        "03"-> "Mie"
        "04"-> "Jue"
        "05"-> "Vie"
        "06"-> "Sab"
        "07"-> "Dom"
    }
    return ""
}