package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;

public class UpdateUserDTO {

    private Boolean status;
    private User user;


    public UpdateUserDTO(Boolean status, User user) {
        this.status = status;
        this.user = user;

    }

    public UpdateUserDTO() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "status=" + status +
                ", user=" + user +
                '}';
    }
}
