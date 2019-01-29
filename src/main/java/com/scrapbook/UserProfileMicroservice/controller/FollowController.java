package com.scrapbook.UserProfileMicroservice.controller;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Follow> add(Follow follow){
        return new ResponseEntity<>(followService.add(follow), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getFollowers", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findByFollowerId(String id){
        List<Follow> stringList = followService.findByFollowerId(id);

        List<String> stringList1 = new ArrayList<>();
        for(Follow temp:stringList)
            stringList1.add(temp.getUserId());
        return new ResponseEntity<>(stringList1, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/getFollow", method = RequestMethod.GET)
    public ResponseEntity<List<String>> findByUserId(String id){
        List<Follow> stringList = followService.findByUserId(id);
        List<String> stringList1 = new ArrayList<>();
        for(Follow temp:stringList)
            stringList1.add(temp.getFollowerId());
        return new ResponseEntity<>(stringList1, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/getFollowDetails", method = RequestMethod.GET)
    public ResponseEntity<List<FollowResponseDTO>> findListByUserId(String id){
        List<FollowResponseDTO> followResponseDTOList = followService.findListByFollowId(id);
        return new ResponseEntity<>(followResponseDTOList, HttpStatus.OK);

    }

}
