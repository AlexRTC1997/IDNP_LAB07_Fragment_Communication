package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView greeting_tv, password_tv, title_tv;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View fragmentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(fragmentView, savedInstanceState);

        title_tv = fragmentView.findViewById(R.id.tv_fb_title);
        greeting_tv = fragmentView.findViewById(R.id.tv_fb_greeting);
        password_tv = fragmentView.findViewById(R.id.tv_fb_password);

        title_tv.setText("Enter your username and your password");

        // Receive data
        getParentFragmentManager().setFragmentResultListener("data", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String username = String.valueOf(result.get("username"));
                String password = String.valueOf(result.get("password"));

                greeting_tv.setText("Welcome " + username);
                password_tv.setText("Your secure password is " + password);
                title_tv.setText("");

            }
        });
    }
}