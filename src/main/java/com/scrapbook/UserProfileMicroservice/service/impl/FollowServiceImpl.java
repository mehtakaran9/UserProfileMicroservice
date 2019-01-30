package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)

public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowRepository followRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public Follow add(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public List<Follow> findByFollowerId(String followerId){

        List<Follow> stringList = followRepository.findByFollowerId(followerId);
        System.out.println(stringList.toString());
        return stringList;
    }

    @Override
    public List<Follow> findByUserId(String followId){
        List<Follow> stringList = followRepository.findByUserId(followId);
        return stringList;
    }

    @Override
    public List<Object> findFollowersListByUserId(String id){
        List<Object> followResponseDTOList1 = followRepository.findFollowersListByUserId(id);


        return followResponseDTOList1;
    }

    @Override
    public List<Object> findUsersByFollowingId(String id) {
        List<Object> followResponseDTOList = followRepository.findUsersByFollowerId(id);
        return followResponseDTOList;
    }

    @Override
    public FollowDTO followResponse(String id){
        FollowDTO followDTO = new FollowDTO();
        User user = userRepository.findOne(id);
        followDTO.setAbout(user.getAbout());
        followDTO.setDateOfBirth(user.getDateOfBirth());
        followDTO.setInterest(user.getInterest());
        followDTO.setUserImageURL(user.getUserImageURL());
        followDTO.setUsername(user.getUsername());
        followDTO.setFollowResponseFollowerList(followRepository.findUsersByFollowerId(id));
        followDTO.setFollowResponseDTOList1(followRepository.findFollowersListByUserId(id));
        return followDTO;


    }
}
