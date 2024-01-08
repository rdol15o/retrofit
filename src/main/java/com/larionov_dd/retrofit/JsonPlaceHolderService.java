package com.larionov_dd.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class JsonPlaceHolderService {
    private Retrofit retrofit;
    private static JsonPlaceHolderService instance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private JsonPlaceHolderService(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JsonPlaceHolderService getInstance(){
        if (instance == null){
            instance = new JsonPlaceHolderService();
        }
        return instance;
    }

    public JsonPlaceHolderApi api(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
