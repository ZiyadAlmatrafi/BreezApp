package com.example.breezapp.rest;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestItem {
    private static RestItem mInstance;
    private static Retrofit retrofit ;
    public static final String BASE_URL = "https://mysmartbreez.mircloud.host";
    private static final String AUTH = "Basic " + Base64.encodeToString(("adsf1234@hotmail.com:asdf1234").getBytes(), Base64.NO_WRAP);
    private static final String AUT = "Text";
    private static final String AU ="text/plain";

    private RestItem() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();

                                Request.Builder requestBuilder = original.newBuilder()

                                        .addHeader("Authorization", AUTH)
                                       // .addHeader("Content-Type", AUT)
                                        .addHeader("Content-Type", "text/plain; charset=utf-8")
                                        //.addHeader("Accept", AU)
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }

                        }
                ).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


    }

    public static synchronized RestItem getInstance() {
        if (mInstance == null) {
            mInstance = new RestItem();
        }
        return mInstance;
    }

    public static APIService getApi() {
        return retrofit.create(APIService.class);
    }
}
