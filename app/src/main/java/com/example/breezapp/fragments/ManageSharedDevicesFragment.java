package com.example.breezapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.breezapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManageSharedDevicesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManageSharedDevicesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManageSharedDevicesFragment extends Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage_shared_devices, container, false);
    }


}
