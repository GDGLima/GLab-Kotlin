package com.gdglima.glabkotlin.gdglimaapp.model

import java.io.Serializable

/**
 * Created by emedinaa on 2/09/17.
 */
class EntityK {

    enum class ItemType {
        HEADER, SPONSOR
    }

    enum class EventType {
        HEADER, EVENT
    }

    data class SpeakerK(val title:String,val country:String, val image:String,
                        val bio:String, val name:String): Serializable

    data class SponsorK(val title:String, val image:String,val type:ItemType):Serializable

    data class EventK(val titulo:String,val horario_inicio:String,val horario_fin:String,
                      val activity:String,val expositor_nombre:String,
                      val fecha:String,val type:EventType):Serializable
}