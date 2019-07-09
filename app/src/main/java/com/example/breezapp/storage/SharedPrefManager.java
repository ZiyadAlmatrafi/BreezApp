package com.example.breezapp.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.breezapp.models.User;


public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "my_shared_preff";
   // private static final String KEY_USERNAME = "keyusername";
   // private static final String KEY_PASSWORD = "keypassword";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }


    public void saveUser(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString(Constants.KEY_USERNAME, user.getUsername());
        editor.putString(Constants.KEY_PASSWORD, user.getPassword());

        editor.apply();


    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constants.KEY_USERNAME,null) != null;
    }

    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(


                sharedPreferences.getString(Constants.KEY_USERNAME, null),
                sharedPreferences.getString(Constants.KEY_PASSWORD, null)
        );
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
