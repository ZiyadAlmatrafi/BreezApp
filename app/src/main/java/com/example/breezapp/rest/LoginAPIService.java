package com.example.breezapp.rest;

import com.example.breezapp.models.LoginResponse;
import com.example.breezapp.models.Thing;
import com.example.breezapp.models.ThingResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginAPIService {

    @FormUrlEncoded
    @POST("/login")  //End Url
    Call<LoginResponse> userLogin(
          @Field("username") String username,
            @Field("password") String password
    );

    @GET("/rest/things")
    Call<ThingResponse> getThings();

   // Call<LoginResponse> userLogin(@Query("tagged") String tags);
}
