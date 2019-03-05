package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

import java.util.Date;

public class UserDTO {

    private String userId;
    private String userImageURL;
    private Date dateOfBirth;
    private String interest;
    private String about;
    private String username;

    public UserDTO(String userId, String username, String userImageURL, Date dateOfBirth, String interest, String about) {
        this.userId = userId;
        this.username = username;
        this.userImageURL = userImageURL;
        this.dateOfBirth = dateOfBirth;
        this.interest = interest;
        this.about = about;
    }

    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userImageURL='" + userImageURL + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", interest='" + interest + '\'' +
                ", about='" + about + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
}
