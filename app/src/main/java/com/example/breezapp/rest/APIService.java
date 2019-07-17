package com.example.breezapp.rest;

import com.example.breezapp.models.LoginResponse;

import com.example.breezapp.models.Thing;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/login")  //End Url
    Call<LoginResponse> userLogin(
          @Field("username") String username,
          @Field("password") String password
    );


/*
    @GET("/rest/things")  //End Url
    Call<ThingsResponse> getThings();

*/
    @GET("/rest/things")
    Call<List<Thing>> getThings();

    @GET("/rest/inbox")
    Call<List<Thing>> getInbox();

   // Call<LoginResponse> userLogin(@Query("tagged") String tags);
}
