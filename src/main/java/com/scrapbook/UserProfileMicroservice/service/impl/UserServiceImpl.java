package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.UserDTO;
import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.exceptions.UserNotFound;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    @Transactional(readOnly = false)
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void delete(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findOne(user.getUserId());
        if(user1!=null){
            return userRepository.save(user1);
        }
        else{
            throw new UserNotFound();
        }
    }

}
