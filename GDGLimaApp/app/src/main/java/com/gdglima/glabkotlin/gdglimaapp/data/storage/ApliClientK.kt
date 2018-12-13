package com.gdglima.glabkotlin.gdglimaapp.data.storage

import com.gdglima.glabkotlin.gdglimaapp.data.model.EventResponseK
import com.gdglima.glabkotlin.gdglimaapp.data.model.SpeakerResponseK
import com.gdglima.glabkotlin.gdglimaapp.data.model.SponsorResponseK
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.File
import java.util.*



/**
 * Created by emedinaa on 2/09/17.
 * https://blooming-oasis-63723.herokuapp.com
 * /speakers
 * /sponsors
 *
 * Caching
 * https://futurestud.io/tutorials/retrofit-2-activate-response-caching-etag-last-modified
 *
 * https://blooming-oasis-63723.herokuapp.com/pucp/talleres?date=2017/09/04
 * https://blooming-oasis-63723.herokuapp.com/gdglima/speakers
 * https://blooming-oasis-63723.herokuapp.com/gdglima/sponsors
 * https://blooming-oasis-63723.herokuapp.com/gdglima/ponencias
 *
 */

class ApliClientK {
    companion object {
        private var servicesApiInterface: ServicesApiInterface? = null
        private val API_BASE_URL = "https://blooming-oasis-63723.herokuapp.com"

        private fun interceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

        private fun defaultCache():Cache{
            val cacheSize:Long=10 * 1024 * 1024;
            val cacheDir = File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString())
            return Cache(cacheDir,cacheSize)
        }

        fun getMyApiClient(): ServicesApiInterface {
            var builder: Retrofit.Builder = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

            var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor())
            httpClient.cache(defaultCache())

            var retrofit: Retrofit = builder.client(httpClient.build()).build()
            servicesApiInterface = retrofit.create(
                    ServicesApiInterface::class.java)

            return servicesApiInterface as ServicesApiInterface
        }
    }
    interface ServicesApiInterface{

        @Headers("Content-Type: application/json")
        @GET("/gdglima/speakers")
        fun speakers():Call<SpeakerResponseK>

        @Headers("Content-Type: application/json")
        @GET("/gdglima/sponsors")
        fun sponsors():Call<SponsorResponseK>

        @Headers("Content-Type: application/json")
        @GET("/gdglima/ponencias")
        fun ponencias():Call<EventResponseK>

        @Headers("Content-Type: application/json")
        @GET("/pucp/talleres")
        fun workshops():Call<EventResponseK>

        @Headers("Content-Type: application/json")
        @GET("/pucp/talleres/fecha")
        fun workshopsByDate(@Query("date") mDate:String):Call<EventResponseK>

        //http://localhost:5000/pucp/ponencias?date=2017/09/06
        @Headers("Content-Type: application/json")
        @GET("/pucp/ponencias")
        fun events(@Query("date") mDate:String):Call<EventResponseK>
    }
}