package com.example.breezapp.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.breezapp.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomesHubsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomesHubsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomesHubsFragment extends Fragment {

    TextView my_address;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_homes_hubs, container, false);

        my_address = (TextView) v.findViewById(R.id.my_address);

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);

        String the_address = preferences.getString("the_address" , "");
        String the_city = preferences.getString("the_city" , "");
        String the_state = preferences.getString("the_state" , "");
        String the_country = preferences.getString("the_country" , "");
        String the_postalCode = preferences.getString("the_postalCode" , "");
        String the_knownName = preferences.getString("the_knownName" , "");

        String ad= the_address + ", " + the_country + ", " + the_postalCode + ", " + the_knownName + ", " + the_city +", " + the_state;

        my_address.setText(ad);

        return v;

    }

}
