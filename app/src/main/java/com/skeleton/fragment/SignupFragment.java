package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class SignupFragment extends Fragment {

    private MaterialEditText mName;
    private MaterialEditText mEmail;
    private MaterialEditText mPass;
    private MaterialEditText mConfPass;
    private MaterialEditText mPhone;
    private MaterialEditText mDOB;
    private boolean check;
    private TextView mSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        init(rootView);

        check = validate();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == true) {


                } else {
                    Toast.makeText(getContext(), "Enter Details Correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

    private boolean validate() {
        if (!ValidateEditText.checkName(mName, true)) {
            return false;
        } else if (!ValidateEditText.checkEmail(mEmail)) {
            return false;
        } else if (!ValidateEditText.checkPassword(mPass, true)) {
            return false;
        } else if (!ValidateEditText.checkPhoneNumber(mPhone)) {
            return false;
        } else if (!ValidateEditText.comparePassword(mPass, mConfPass)) {
            return false;
        }
        return true;

    }

    private void init(View view) {

        mName = (MaterialEditText) view.findViewById(R.id.et_name);
        mPhone = (MaterialEditText) view.findViewById(R.id.et_phone);
        mPass = (MaterialEditText) view.findViewById(R.id.et_pass);
        mConfPass = (MaterialEditText) view.findViewById(R.id.et_confpass);
        mDOB = (MaterialEditText) view.findViewById(R.id.et_dob);
        mEmail = (MaterialEditText) view.findViewById(R.id.et_email);
        mSubmit = (TextView) view.findViewById(R.id.submit);

    }
}
