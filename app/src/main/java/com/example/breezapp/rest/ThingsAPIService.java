package com.example.breezapp.rest;

import com.example.breezapp.Models.ThingsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ThingsAPIService {
    @GET("/rest/things")  //End Url
    Call<ThingsList> fetchThings(@Query("tagged") String tags);
}
