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
        mMessage = (EditText) v.findViewById(R.id.messageBody);
        btnSend = (Button)v.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFeedBack();

            }
        });

        return v;
    }


    private void checkFeedBack() {

        final String subject = mSubject.getText().toString().trim();
        final String message = mMessage.getText().toString().trim();

        if (subject.isEmpty()) {
            mSubject.setError("Subject is required");
            mSubject.requestFocus();
            return;
        }
        if (message.isEmpty()) {
            mMessage.setError("Message is required");
            mMessage.requestFocus();
            return;
        }

        String to = "ziad12441@gmail.com";
        String sub = mSubject.getText().toString();
        String mess = mMessage.getText().toString();

        Intent mail = new Intent(Intent.ACTION_SEND);
        mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
        mail.putExtra(Intent.EXTRA_SUBJECT, sub);
        mail.putExtra(Intent.EXTRA_TEXT, mess);

        mail.setType("message/rfc822");
        startActivity(Intent.createChooser(mail, "Send email via:"));

    }


}
