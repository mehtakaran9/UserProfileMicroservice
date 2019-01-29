package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.UserDTO;
import com.scrapbook.UserProfileMicroservice.entity.User;

public interface UserService {
    User add(User user);

    User findOne(String customerId);

    void delete(String userId);

    User updateUser(User user);
}
