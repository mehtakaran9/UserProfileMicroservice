package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

public class FollowResponseDTO {
    private String followerId;
    private String username;
    private String followerImage;

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollowerImage() {
        return followerImage;
    }

    public void setFollowerImage(String followerImage) {
        this.followerImage = followerImage;
    }

    public FollowResponseDTO(String followerId, String username, String followerImage) {
        this.followerId = followerId;
        this.username = username;
        this.followerImage = followerImage;
    }

    public FollowResponseDTO() {
    }

    @Override
    public String toString() {
        return "FollowResponseDTO{" +
                "followerId='" + followerId + '\'' +
                ", username='" + username + '\'' +
                ", followerImage='" + followerImage + '\'' +
                '}';
    }
}
