package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
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
    public List<FollowResponseDTO> findListByFollowId(String id){
        List<FollowResponseDTO> followResponseDTOList = followRepository.findListByFollowId(id);
        return followResponseDTOList;
    }
}
