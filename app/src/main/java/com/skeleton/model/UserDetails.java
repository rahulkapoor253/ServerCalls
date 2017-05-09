package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rahulkapoor on 09/05/17.
 */

public class UserDetails {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("newNumber")
    @Expose
    private String newNumber;
    @SerializedName("userImages")
    @Expose
    private List<UserImage> userImages = null;
    @SerializedName("admin_deactivateAccount")
    @Expose
    private Boolean adminDeactivateAccount;
    @SerializedName("timeOffset")
    @Expose
    private Integer timeOffset;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("aboutMe")
    @Expose
    private String aboutMe;
    @SerializedName("step2CompleteOrSkip")
    @Expose
    private Boolean step2CompleteOrSkip;
    @SerializedName("step1CompleteOrSkip")
    @Expose
    private Boolean step1CompleteOrSkip;
    @SerializedName("interestCategories")
    @Expose
    private List<Object> interestCategories = null;
    @SerializedName("profilePicURL")
    @Expose
    private ProfilePicURL profilePicURL;
    @SerializedName("defaultAddressId")
    @Expose
    private Object defaultAddressId;
    @SerializedName("currentLocation")
    @Expose
    private CurrentLocation currentLocation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public List<UserImage> getUserImages() {
        return userImages;
    }

    public void setUserImages(List<UserImage> userImages) {
        this.userImages = userImages;
    }

    public Boolean getAdminDeactivateAccount() {
        return adminDeactivateAccount;
    }

    public void setAdminDeactivateAccount(Boolean adminDeactivateAccount) {
        this.adminDeactivateAccount = adminDeactivateAccount;
    }

    public Integer getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(Integer timeOffset) {
        this.timeOffset = timeOffset;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Boolean getStep2CompleteOrSkip() {
        return step2CompleteOrSkip;
    }

    public void setStep2CompleteOrSkip(Boolean step2CompleteOrSkip) {
        this.step2CompleteOrSkip = step2CompleteOrSkip;
    }

    public Boolean getStep1CompleteOrSkip() {
        return step1CompleteOrSkip;
    }

    public void setStep1CompleteOrSkip(Boolean step1CompleteOrSkip) {
        this.step1CompleteOrSkip = step1CompleteOrSkip;
    }

    public List<Object> getInterestCategories() {
        return interestCategories;
    }

    public void setInterestCategories(List<Object> interestCategories) {
        this.interestCategories = interestCategories;
    }

    public ProfilePicURL getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(ProfilePicURL profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public Object getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Object defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }

    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(CurrentLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

}
