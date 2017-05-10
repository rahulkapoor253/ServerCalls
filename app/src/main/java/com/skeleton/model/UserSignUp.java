package com.skeleton.model;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class UserSignUp {

    private String mUserName, mUserEmail, mUserPass, mUserPhone, mUserDOB, mUserToken, mDeviceVersion, mCountryCode, mDeviceType, mLang, mGender;

    public UserSignUp(String UserName, String UserDOB, String UserEmail, String UserPhone, String UserPass, String token, String version, String countryCode, String lang, String deviceType, String gender)
    {
        this.mUserDOB = UserDOB;
        this.mUserEmail = UserEmail;
        this.mUserName = UserName;
        this.mUserPass = UserPass;
        this.mUserPhone = UserPhone;
        this.mUserToken = token;
        this.mDeviceVersion = version;
        this.mLang = lang;
        this.mCountryCode = countryCode;
        this.mDeviceType = deviceType;
        this.mGender = gender;

    }

    public String getmFirstName() {
        return mUserName;
    }

    /**
     * @return date of birth of user
     */
    public String getmDOB() {
        return mUserDOB;
    }

    /**
     * @return phone number of user
     */
    public String getmPhoneNo() {
        return mUserPhone;
    }

    /**
     * @return email of user
     */
    public String getmEmail() {
        return mUserEmail;
    }

    public String getmPass() {

        return mUserPass;
    }

    public String getmUserToken() {
        return mUserToken;
    }

    public String getmDeviceVersion() {
        return mDeviceVersion;

    }

    public String getmCountryCode() {
        return mCountryCode;

    }

    public String getmLang() {
        return mLang;

    }

    public String getmDeviceType() {
        return mDeviceType;

    }

    public String getmGender() {
        return mGender;
    }


}
