package com.scrapbook.UserProfileMicroservice.entity;/* Made by: mehtakaran9 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = User.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "userId")})
public class User {
    public static final String TABLE_NAME = "UserProfile";
    public static final String ID_COLUMN = "userId";
    @Id
    @Column(name = User.ID_COLUMN)
    private String userId;
    private String userImageURL;

    private Date dateOfBirth;

    private String username;
    private String interest;
    private String about;

    public User() {

    }

    public User(String userId, String userImageURL, String username, Date dateOfBirth, String interest, String about) {
        this.userId = userId;
        this.userImageURL = userImageURL;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.interest = interest;
        this.about = about;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userImageURL='" + userImageURL + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", username='" + username + '\'' +
                ", interest='" + interest + '\'' +
                ", about='" + about + '\'' +
                '}';
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
