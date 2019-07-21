package com.example.breezapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.breezapp.activities.AuthenticationActivity;
import com.example.breezapp.activities.HomeActivity;
import com.example.breezapp.activities.MapsActivity;
import com.example.breezapp.R;

import static android.content.Context.MODE_PRIVATE;



/**
 * A simple {@link Fragment} subclass.
 */
public class HubFragment extends Fragment {



    Button hub_button;
    TextView use_maps , street , locality , city_state;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hub, container, false);

        hub_button = (Button) v.findViewById(R.id.hub_button);
        use_maps = (TextView) v.findViewById(R.id.use_maps);

        street = (TextView) v.findViewById(R.id.street);
        locality = (TextView) v.findViewById(R.id.locality);
        city_state = (TextView) v.findViewById(R.id.city_state);

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);

        String the_address = preferences.getString("the_address" , "");
        String the_city = preferences.getString("the_city" , "");
        String the_state = preferences.getString("the_state" , "");
        String the_country = preferences.getString("the_country" , "");
        String the_postalCode = preferences.getString("the_postalCode" , "");
        String the_knownName = preferences.getString("the_knownName" , "");

        street.setText(the_address);
        locality.setText(the_country + ", " + the_postalCode + ", " + the_knownName);
        city_state.setText(the_city +", " + the_state);

        hub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), AuthenticationActivity.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        use_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);

            }
        });

        return v;
    }

}
