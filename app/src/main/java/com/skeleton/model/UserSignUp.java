package com.skeleton.model;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class UserSignUp {

    private String mUserName, mUserEmail, mUserPass, mUserPhone, mUserDOB;

    public UserSignUp(String UserName, String UserDOB, String UserEmail, String UserPhone, String UserPass)
    {
        this.mUserDOB = UserDOB;
        this.mUserEmail = UserEmail;
        this.mUserName = UserName;
        this.mUserPass = UserPass;
        this.mUserPhone = UserPhone;

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


}
