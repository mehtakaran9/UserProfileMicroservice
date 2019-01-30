package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

import javax.persistence.Entity;

public class FollowResponseDTO {
    private String userId;
    private String username;
    private String userImageURL;

    public FollowResponseDTO() {

    }

    public FollowResponseDTO(String userId, String username, String userImageURL) {
        this.userId = userId;
        this.username = username;
        this.userImageURL = userImageURL;
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

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}
