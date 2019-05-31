package com.example.restapp.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RecyclerInterface {

    String JSONURL = "http://192.168.1.108:8000/api/productos/";

    @GET("list")
    Call<String> getString();
}