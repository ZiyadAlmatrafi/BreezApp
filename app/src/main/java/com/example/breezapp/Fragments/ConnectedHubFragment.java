package com.example.breezapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breezapp.R;


public class ConnectedHubFragment extends Fragment {

Button foundButton;
Button notFoundButton;


   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConnectedHubFragment.this, AuthenticationActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH);
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_connected_hub, container, false);

        foundButton = (Button) v.findViewById(R.id.foundButton);
        notFoundButton = (Button) v.findViewById(R.id.notFoundButton);
        foundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubFoundFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        notFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame,new HubNotFoundFragment() );
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }


}
