package com.example.breezapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.breezapp.R;


public class FeedBackFragment extends Fragment {

    //TextView to;
    EditText mSubject;
    EditText mMessage;
    Button btnSend;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_feed_back, container, false);
        mSubject = (EditText) v.findViewById(R.id.subject);

        btnSend = (Button)v.findViewById(R.id.btnSend);
        /*
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = "ziad12441@gmail.com";
               // String to = ((EditText)view.findViewById(R.id.txtTo)).getText().toString();
                String sub = ((EditText)view.findViewById(R.id.subject)).getText().toString();
                mSubject = (EditText) v.findViewById(R.id.subject).getTe
                String mess = ((EditText)view.findViewById(R.id.messageBody)).getText().toString();

                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Send email via:"));
            }
        });
        */
        return v;
    }


}
