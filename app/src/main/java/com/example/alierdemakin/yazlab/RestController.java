package com.example.alierdemakin.yazlab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by AliErdem.Akin on 18.05.2017.
 */

public interface RestController {
    @POST("getAllHome")
    Call<List<Home>> getAllHome();

    @POST("insertHome")
    Call<String> insertHome(@Header("home") String home);

    @POST("updateHome")
    Call<String> updateHome(@Header("home") String home);

    @POST("deleteHome")
    Call<String> deleteHome(@Header("home") String home);
}
