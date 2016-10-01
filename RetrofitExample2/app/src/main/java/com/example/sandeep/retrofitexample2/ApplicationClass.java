package com.example.sandeep.retrofitexample2;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;


public class ApplicationClass extends Application {

    public static final String BASE_URL  = "http://autozoneuae.com/test/";

    Gson gson;
//    Retrofit retrofit;


    private static ApplicationClass ourInstance = new ApplicationClass();

    public static ApplicationClass getInstance() {
        return ourInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        LoadConfigurations();
    }

    public  void LoadConfigurations() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
    }



}
