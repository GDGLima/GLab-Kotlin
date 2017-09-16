package com.gdglima.glabkotlin.gdglimaapp.data.storage;

import com.gdglima.glabkotlin.gdglimaapp.data.model.SpeakerResponse;
import com.gdglima.glabkotlin.gdglimaapp.data.model.SponsorResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by emedinaa on 2/09/17.
 */

public class ApliClient {

    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;

    private static final String API_BASE="https://blooming-oasis-63723.herokuapp.com";

    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(API_BASE)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient =new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);

        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        @Headers("Content-Type: application/json")
        @POST("/gdglima/speakers")
        Call<SpeakerResponse> speakers();

        @Headers("Content-Type: application/json")
        @GET("/gdglima/sponsors")
        Call<SponsorResponse> sponsors();

    }
}
