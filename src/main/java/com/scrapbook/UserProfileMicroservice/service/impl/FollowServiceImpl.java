package com.scrapbook.UserProfileMicroservice.service.impl;/* Made by: mehtakaran9 */

import com.contest.notificationProducer.dto.Header;
import com.contest.notificationProducer.exception.FieldsCanNotBeEmpty;
import com.contest.notificationProducer.notificationEnum.NotificationMedium;
import com.contest.notificationProducer.notificationEnum.NotificationType;
import com.contest.notificationProducer.producer.FollowProducer;
import com.recommendation.kafka_sdk.dto.FollowKafkaMessage;
import com.recommendation.kafka_sdk.socialnetwork.FollowKafkaProducer;
import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.exceptions.NullValueException;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.repository.UserRepository;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowRepository followRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowKafkaProducer followKafkaProducer;
    @Autowired
    FollowProducer followProducer;

    private Object object;

    @Override
    @Transactional(readOnly = false)
    public Follow add(Follow follow) {
        if((follow.getUserId()!=null)&&(follow.getFollowerId()!=null)){
        Follow resp=followRepository.save(follow);
        if(resp!=null)
        {
            FollowKafkaMessage followKafkaMessage=new FollowKafkaMessage();
            followKafkaMessage.setUserId(follow.getFollowerId());
            followKafkaMessage.setUserIdForFollowed(follow.getUserId());
            followKafkaMessage.setTimestamp(System.nanoTime());
            followKafkaProducer.sendFollowKafkaMessage(followKafkaMessage);
        }
            Header header=new Header();
            com.contest.notificationProducer.dto.Follow followNotfication=new com.contest.notificationProducer.dto.Follow();
            followNotfication.setSender(follow.getFollowerId());
            List<NotificationMedium> notificationMediumList=new ArrayList<>();
            notificationMediumList.add(NotificationMedium.EMAIL);
            header.setNotificationMedium(notificationMediumList);
            header.setNotificationType(NotificationType.FOLLOW);
            header.setNotificationTypeBody(followNotfication);
            header.setTimeStamp(new java.util.Date().toString());
            header.setReceiver(follow.getUserId());
            try {
                followProducer.send(header);
            } catch (FieldsCanNotBeEmpty fieldsCanNotBeEmpty) {
                fieldsCanNotBeEmpty.printStackTrace();
            }

            return resp;
        }
        else{
            throw new NullValueException();
        }

    }

    @Override
    public List<Follow> findByFollowerId(String followerId){

        List<Follow> stringList = followRepository.findByFollowerId(followerId);
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

    @Override
    public void deleteByUserIdAndFollowerId(String userId, String followerId) {
        followRepository.deleteByUserIdAndFollowerId(userId, followerId);
    }

    @Override
    public void deleteFollowByUserId(String userId){
        followRepository.deleteFollowByUserId(userId);
    }
}
