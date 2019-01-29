package com.scrapbook.UserProfileMicroservice.controller;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.Follow;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Follow> add(Follow follow){
        return new ResponseEntity<Follow>(followService.add(follow), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.POST)
    public void unfollow(String followId, String followerId){
        followService.unfollow(followId, followerId);
    }

    @RequestMapping(value = "/getFollowers", method = RequestMethod.GET)
    public ResponseEntity<List<Follow>> findByFollowerId(String id){
        List<Follow> stringList = followService.findByFollowerId(id);
        return new ResponseEntity<>(stringList, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/getFollow", method = RequestMethod.GET)
    public ResponseEntity<List<Follow>> findByFollowId(String id){
        List<Follow> stringList = followService.findByFollowId(id);
        for(Follow temp:stringList)
            System.out.println(temp.toString());
        return new ResponseEntity<>(stringList, HttpStatus.ACCEPTED);
    }

}
