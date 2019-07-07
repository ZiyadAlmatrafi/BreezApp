package com.example.breezapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnterHubCodeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnterHubCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnterHubCodeFragment extends Fragment {

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_enter_hub_code, container, false);

        button = (Button) v.findViewById(R.id.hub_code_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }

}
