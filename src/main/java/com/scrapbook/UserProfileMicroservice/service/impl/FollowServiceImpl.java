package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */


import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)

public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowRepository followRepository;

    @Override
    @Transactional(readOnly = false)
    public Follow add(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public void unfollow(String followId, String followerId) {
        followRepository.unfollow(followId, followerId);
    }

    @Override
    public List<Follow> findByFollowerId(String followerId){

        List<Follow> stringList = followRepository.findByFollowerId(followerId);
        System.out.println(stringList.toString());
        return stringList;
    }

    @Override
    public List<Follow> findByFollowId(String followId){
        List<Follow> stringList = followRepository.findByFollowId(followId);
        return stringList;
    }
}
