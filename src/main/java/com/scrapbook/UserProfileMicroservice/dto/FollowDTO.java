package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */


import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;

public class FollowDTO {
    private String userImageURL;
    private Date dateOfBirth;
    private String interest;
    private String about;
    private String username;
    private List<Object> followResponseFollowerList;
    private List<Object> followResponseDTOList1;

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Object> getFollowResponseFollowerList() {
        return followResponseFollowerList;
    }

    public void setFollowResponseFollowerList(List<Object> followResponseFollowerList) {
        this.followResponseFollowerList = followResponseFollowerList;
    }

    public List<Object> getFollowResponseDTOList1() {
        return followResponseDTOList1;
    }

    public void setFollowResponseDTOList1(List<Object> followResponseDTOList1) {
        this.followResponseDTOList1 = followResponseDTOList1;
    }
}
