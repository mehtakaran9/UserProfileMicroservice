package com.scrapbook.UserProfileMicroservice.controller;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.exceptions.AlreadyFollowing;
import com.scrapbook.UserProfileMicroservice.repository.FollowRepository;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Follow> add(@RequestBody Follow follow){
        List<Follow> followList=followRepository.findByUserId(follow.getUserId());
        System.out.println(followList.toString());
        System.out.println(follow.toString());
        for(Follow temp: followList) {
            if(temp.getFollowerId().equals(follow.getFollowerId())&&temp.getUserId().equals(follow.getUserId()))
            throw new AlreadyFollowing();
        }


        return new ResponseEntity<>(followService.add(follow), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getFollowers/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findByFollowerId(@PathVariable String id){
        List<Follow> stringList = followService.findByFollowerId(id);

        List<String> stringList1 = new ArrayList<>();
        for(Follow temp:stringList)
            stringList1.add(temp.getUserId());
        return new ResponseEntity<>(stringList1, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/getFollow/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findByUserId(@PathVariable String id){
        List<Follow> stringList = followService.findByUserId(id);
        List<String> stringList1 = new ArrayList<>();
        for(Follow temp:stringList)
            stringList1.add(temp.getFollowerId());
        return new ResponseEntity<>(stringList1, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.DELETE)
    public void unfollow(String userId, String followerId){
        followService.deleteByUserIdAndFollowerId(userId, followerId);
    }

    @RequestMapping(value = "/getFollowDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FollowResponseDTO>> findFollowersListByUserId(@PathVariable String id) {
        List<FollowResponseDTO> followResponseDTOList = followService.findFollowersListByUserId(id);
        return new ResponseEntity<>(followResponseDTOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getFollowerDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FollowResponseDTO>> findUsersByFollowingId(@PathVariable String id){
        List<FollowResponseDTO> followResponseDTOList = followService.findUsersByFollowingId(id);
        return new ResponseEntity<>(followResponseDTOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getFollowResponse/{id}", method = RequestMethod.GET)
    public ResponseEntity<FollowDTO> followResponse(@PathVariable String id){
        FollowDTO followDTO = followService.followResponse(id);
        return new ResponseEntity<>(followDTO, HttpStatus.OK);
    }



}
