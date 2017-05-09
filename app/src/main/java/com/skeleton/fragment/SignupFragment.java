package com.skeleton.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.model.Example;
import com.skeleton.model.UserSignUp;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;
import com.skeleton.util.imagepicker.ImageChooser;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;

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
    private TextView mSubmit;
    private String mUserName, mUserEmail, mUserPass, mUserPhone, mUserDOB;
    private Example userData;
    private File mImageFile;
    private CircleImageView mUserImage;
    private Uri uriImage;
    private ImageChooser imageChooser;
    private UserSignUp obj;
    private CheckBox mTick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        init(rootView);

        mUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    uploadData();

                } else {
                    Toast.makeText(getContext(), "Enter Details Correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

    private void chooseImage() {
        imageChooser = new ImageChooser.Builder(this).setCropEnabled(false).build();
        imageChooser.selectImage(new ImageChooser.OnImageSelectListener() {
            @Override
            public void loadImage(final List<ChosenImage> list) {
                uriImage = Uri.parse(list.get(0).getQueryUri());
                mImageFile = new File(String.valueOf(uriImage));
                if (uriImage != null) {
                    mUserImage.setImageURI(uriImage);
                }
            }

            @Override
            public void croppedImage(final File mCroppedImage) {

            }
        });
    }


    private void uploadData() {

        obj = new UserSignUp(mUserName, mUserDOB, mUserEmail, mUserPhone, mUserPass);

        HashMap<String, RequestBody> params = new MultipartParams.Builder()
                .add("firstName", mUserName)
                .add("dob", mUserDOB)
                .add("phoneNo", mUserPhone)
                .add("email", mUserEmail)
                .add("password", mUserPass)
                .add("profilePic", mImageFile)
                .build().getMap();

        RestClient.getApiInterface().register(params).enqueue(new ResponseResolver<Example>(getContext(), true) {
            @Override
            public void success(Example example) {
                Toast.makeText(getContext(), example.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(APIError error) {

            }
        });

    }

    private boolean validate() {
        if (uriImage == null) {
            Toast.makeText(getContext(), "Choose a profile picture first!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!ValidateEditText.checkName(mName, true)) {
            return false;
        }
        if (!ValidateEditText.checkEmail(mEmail)) {
            return false;
        }
        if (!ValidateEditText.checkPassword(mPass, true)) {
            return false;
        }
        if (!ValidateEditText.checkPhoneNumber(mPhone)) {
            return false;
        }
        if (!ValidateEditText.comparePassword(mPass, mConfPass)) {
            return false;
        }
        if (!mTick.isChecked()) {
            Toast.makeText(getContext(), "check the terms first!", Toast.LENGTH_LONG).show();
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
        mUserImage = (CircleImageView) view.findViewById(R.id.user_image);
        mTick = (CheckBox) view.findViewById(R.id.cb_signup_tick);

        mUserDOB = mDOB.getText().toString();
        mUserEmail = mEmail.getText().toString();
        mUserPass = mPass.getText().toString();
        mUserName = mName.getText().toString();
        mUserPhone = mPhone.getText().toString();

    }
}
