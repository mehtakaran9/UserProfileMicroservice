package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User add(User user);

    User findOne(String customerId);

    void deleteByUserId(String userId);

    List<User> searchByUserName(String username);

    User updateUser(User user);

}
