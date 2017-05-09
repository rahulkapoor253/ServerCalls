package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class SigninFragment extends Fragment {


    private MaterialEditText etEmail;
    private MaterialEditText etPassword;
    private CheckBox cbTick;
    private TextView btnsignup;
    private TextView btnsignin;
    private boolean isCheck;
    private String mUserEmail, mUserPass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        init(rootView);

        isCheck = validate();

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCheck == true) {

                } else {
                    Toast.makeText(getContext(), "Sign In again with correct details", Toast.LENGTH_LONG).show();
                }

            }
        });


        return rootView;
    }

    private boolean validate() {

        if (!ValidateEditText.checkEmail(etEmail)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etPassword, true)) {
            return false;
        }

        return true;
    }

    private void init(View view) {
        etEmail = (MaterialEditText) view.findViewById(R.id.et_signin_email);
        etPassword = (MaterialEditText) view.findViewById(R.id.et_signin_password);
        cbTick = (CheckBox) view.findViewById(R.id.cb_signin_tick);
        btnsignin = (TextView) view.findViewById(R.id.btn_signin);
        btnsignup = (TextView) view.findViewById(R.id.btn_signup);

        mUserEmail = etEmail.getText().toString();
        mUserPass = etPassword.getText().toString();

    }


}
