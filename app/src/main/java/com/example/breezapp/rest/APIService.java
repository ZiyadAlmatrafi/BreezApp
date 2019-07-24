package com.example.breezapp.rest;

import android.support.v4.media.MediaMetadataCompat;

import com.example.breezapp.models.Item;
import com.example.breezapp.models.LoginResponse;

import com.example.breezapp.models.Thing;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @FormUrlEncoded
    @POST("/login")  //End Url
    Call<LoginResponse> userLogin(
          @Field("username") String username,
          @Field("password") String password
    );



    @GET("/rest/things")
    Call<List<Thing>> getThings();

    @GET("/rest/inbox")
    Call<List<Thing>> getInbox();

    @GET("/rest/items")
    Call<List<Item>> getItems();

    @Headers("Content-Type: text/plain")
   @POST("/rest/items/{itemname}")
  // @Headers("Content-Type: text/plain")

   Call<Void> postItem(@Path ("itemname")String itemName, @Body String state);



   /*

   @Headers("Content-Type: text/plain")
    @POST("/rest/items/zigbee_device_cf1977a3_000d6f000f95686f_000D6F000F95686F_1_switch")
    Call<String> postItemSwitch( @Body String state);*/

   /* @POST("/rest/items/{itemname}")
    public void postItem(@Path ("itemname")String itemname, @Body String state)
    {
    }*/

/*
@POST("/rest/items/{itemname}")
   void postItem(@Path ("itemname")String itemname, @Body String state);

 */
}
