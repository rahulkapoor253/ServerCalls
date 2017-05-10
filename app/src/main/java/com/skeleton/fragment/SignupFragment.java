package com.skeleton.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.model.Example;
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
    private CheckBox mTick;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private int mGender;
    private String mUserToken = "ABCD", mUserAppVersion = "VERSION", mCountryCode = "+91", mLang = "EN", mDeviceType = "ANDROID";

    /**
     * @param inflater           inflater
     * @param container          container
     * @param savedInstanceState current instance is saved;
     * @return return
     */
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        init(rootView);

        mUserImage.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v view
             */
            @Override
            public void onClick(final View v) {
                chooseImage();
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v view
             */
            @Override
            public void onClick(final View v) {
                if (validate()) {
                    setData();
                    uploadData();

                } else {
                    Toast.makeText(getContext(), "Enter Details Correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

    /**
     * set data
     */
    private void setData() {
        mUserDOB = mDOB.getText().toString();
        mUserEmail = mEmail.getText().toString();
        mUserPass = mPass.getText().toString();
        mUserName = mName.getText().toString();
        mUserPhone = mPhone.getText().toString();
    }

    /**
     * image chooser
     */
    private void chooseImage() {
        imageChooser = new ImageChooser.Builder(this).setCropEnabled(false).build();
        imageChooser.selectImage(new ImageChooser.OnImageSelectListener() {
            /**
             *
             * @param list the list
             */
            @Override
            public void loadImage(final List<ChosenImage> list) {
                mImageFile = new File(list.get(0).getOriginalPath());
                Glide.with(SignupFragment.this)
                        .load(list.get(0).getQueryUri())
                        .into(mUserImage);

            }

            /**
             *
             * @param mCroppedImage the m cropped image
             */
            @Override
            public void croppedImage(final File mCroppedImage) {

            }
        });
    }

    /**
     * @param requestCode  request code
     * @param permissions  permissions
     * @param grantResults grant results
     */
    @Override
    public void onRequestPermissionsResult(final int requestCode, final String[] permissions, final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imageChooser.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * @param requestCode req code
     * @param resultCode  result code
     * @param data        data
     */
    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageChooser.onActivityResult(requestCode, resultCode, data);

    }

    /**
     * upload data
     */
    private void uploadData() {

        HashMap<String, RequestBody> params = new MultipartParams.Builder()
                .add("firstName", mUserName)
                .add("dob", mUserDOB)
                .add("phoneNo", mUserPhone)
                .add("email", mUserEmail)
                .add("password", mUserPass)
                .addFile("profilePic", mImageFile)
                .add("deviceToken", mUserToken)
                .add("appVersion", mUserAppVersion)
                .add("countryCode", mCountryCode)
                .add("language", mLang)
                .add("deviceType", mDeviceType)
                .add("gender", mGender)
                .build().getMap();

        RestClient.getApiInterface().register(params).enqueue(new ResponseResolver<Example>(getContext(), true) {
            /**
             *
             * @param example example
             */
            @Override
            public void success(final Example example) {
                Toast.makeText(getContext(), example.getMessage(), Toast.LENGTH_SHORT).show();
            }

            /**
             *
             * @param error the error
             */
            @Override
            public void failure(final APIError error) {

            }
        });

    }

    /**
     * @return return boolean
     */
    private boolean validate() {

        mGender = rgGender.getCheckedRadioButtonId();
        int checkVal = checkGender();
        mGender = checkVal;

        if (mImageFile == null) {
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
        if (mGender == -1) {
            return false;
        }
        if (!mTick.isChecked()) {
            Toast.makeText(getContext(), "check the terms first!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

    /**
     * @return checkGender
     */
    private int checkGender() {

        if (rbMale.isChecked()) {
            return 0;
        }
        if (rbFemale.isChecked()) {
            return 1;
        }

        return -1;
    }

    /**
     * @param view view
     */
    private void init(final View view) {

        mName = (MaterialEditText) view.findViewById(R.id.et_name);
        mPhone = (MaterialEditText) view.findViewById(R.id.et_phone);
        mPass = (MaterialEditText) view.findViewById(R.id.et_pass);
        mConfPass = (MaterialEditText) view.findViewById(R.id.et_confpass);
        mDOB = (MaterialEditText) view.findViewById(R.id.et_dob);
        mEmail = (MaterialEditText) view.findViewById(R.id.et_email);
        mSubmit = (TextView) view.findViewById(R.id.submit);
        mUserImage = (CircleImageView) view.findViewById(R.id.user_image);
        mTick = (CheckBox) view.findViewById(R.id.cb_signup_tick);
        rgGender = (RadioGroup) view.findViewById(R.id.rg_gender);
        rbMale = (RadioButton) view.findViewById(R.id.rb_male);
        rbFemale = (RadioButton) view.findViewById(R.id.rb_female);

    }
}
