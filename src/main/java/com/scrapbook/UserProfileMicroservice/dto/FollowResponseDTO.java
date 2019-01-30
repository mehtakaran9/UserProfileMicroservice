package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

public class FollowResponseDTO {
    private String user_id;
    private String username;
    private String user_imageurl;

    public FollowResponseDTO() {

    }

    @Override
    public String toString() {
        return "FollowResponseDTO{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", user_imageurl='" + user_imageurl + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_imageurl() {
        return user_imageurl;
    }

    public void setUser_imageurl(String user_imageurl) {
        this.user_imageurl = user_imageurl;
    }

    public FollowResponseDTO(String user_id, String username, String user_imageurl) {
        this.user_id = user_id;
        this.username = username;
        this.user_imageurl = user_imageurl;
    }
}
