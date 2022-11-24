package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    Button login_btn;
    EditText username_et, password_et;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View fragmentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(fragmentView, savedInstanceState);

        login_btn = fragmentView.findViewById(R.id.btn_fa_login);
        username_et = fragmentView.findViewById(R.id.et_fa_username);
        password_et = fragmentView.findViewById(R.id.et_fa_password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send data
                Bundle bundle = new Bundle();

                bundle.putString("username", username_et.getText().toString());
                bundle.putString("password", password_et.getText().toString());

                getParentFragmentManager().setFragmentResult("data", bundle);
            }
        });

    }
}