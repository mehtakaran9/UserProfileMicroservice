package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.exceptions.UserNotFound;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowRepository followRepository;

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
        followRepository.deleteFollowByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchByUserName(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findOne(user.getUserId());

        System.out.println(user1.toString());
        if (user.getAbout() == null) {
            user.setAbout("No About added");
        }

        if (user.getUserImageURL() == null) {
            user.setUserImageURL("https://www.nicepng.com/png/detail/301-3012856_account-user-profile-avatar-comments-free-image-user.png");
        }
        if (user.getUsername() == null) {
            throw new UserNotFound();
        }
        if (user.getInterest() == null) {
            user.setInterest("No Interest Added");
        }
        if (user.getDateOfBirth() == null) {
            user.setDateOfBirth(new Date());
        }
        if (user != null) {
            return userRepository.save(user);
        } else {
            throw new UserNotFound();
        }
    }

}
