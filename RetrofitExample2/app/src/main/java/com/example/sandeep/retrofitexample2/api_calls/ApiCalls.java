package com.example.sandeep.retrofitexample2.api_calls;

import com.example.sandeep.retrofitexample2.ApplicationClass;
import com.example.sandeep.retrofitexample2.model.Category;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Call;

public interface ApiCalls {

    @GET("/getAllCategoryData.php")
    public void getCats(Callback<List<Category>> response);

    @GET("/getAllCategoryData.php")
    List<Category> getCats();

    @GET("/getAllCategoryData.php")
    Call<String> getValues();

    @GET("/getAllCategoryData.php")
    Call<List<Category>> getAllCats();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApplicationClass.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}