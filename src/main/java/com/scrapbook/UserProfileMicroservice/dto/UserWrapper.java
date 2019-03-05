package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;

import java.util.List;

public class UserWrapper {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserWrapper{" +
                "userList=" + userList +
                '}';
    }
}
