package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;
    private Object object;

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
    public List<FollowResponseDTO> findFollowersListByUserId(String id){
        List<Object[]> temp=followRepository.findFollowersListByUserId(id);
        List<FollowResponseDTO> temptemp=new ArrayList<FollowResponseDTO>();
       for(Object[] oneFollower: temp)
        {
            FollowResponseDTO followResponseDTO=new FollowResponseDTO();
            followResponseDTO.setUserId(oneFollower[0].toString());
            followResponseDTO.setUsername(oneFollower[1].toString());
            followResponseDTO.setUserImageURL(oneFollower[2].toString());
            temptemp.add(followResponseDTO);

        }

        return temptemp;
    }

    @Override
    public List<FollowResponseDTO> findUsersByFollowingId(String id) {
        List<Object[]> temp=followRepository.findUsersByFollowerId(id);
        List<FollowResponseDTO> temptemp=new ArrayList<FollowResponseDTO>();
        for(Object[] oneFollower: temp)
        {
            FollowResponseDTO followResponseDTO=new FollowResponseDTO();
            followResponseDTO.setUserId(oneFollower[0].toString());
            followResponseDTO.setUsername(oneFollower[1].toString());
            followResponseDTO.setUserImageURL(oneFollower[2].toString());
            temptemp.add(followResponseDTO);

        }
        return temptemp;

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
        followDTO.setFollowResponseFollowerList(findFollowersListByUserId(id));
        followDTO.setFollowResponseDTOList1(findUsersByFollowingId(id));
        return followDTO;


    }
}
