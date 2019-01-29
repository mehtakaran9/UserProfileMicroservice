package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.exceptions.UserNotFound;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void deleteByUserId(String userId) {
        userRepository.delete(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchByUserName(String username) {
//        System.out.println(userName);
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findOne(user.getUserId());
        if(user1!=null){
            return userRepository.save(user);
        }
        else{
            throw new UserNotFound();
        }
    }

}
