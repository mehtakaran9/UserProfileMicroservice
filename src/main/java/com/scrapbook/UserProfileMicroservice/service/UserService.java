package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User findOne(String customerId);

//    List<String> findByUserId(String userId);

    User updateUser(User user);

    void deleteByUserId(String userId);

    List<User> searchByUserName(String userName);
}
