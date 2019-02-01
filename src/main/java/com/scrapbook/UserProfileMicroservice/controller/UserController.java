package com.scrapbook.UserProfileMicroservice.controller;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.UpdateUserDTO;
import com.scrapbook.UserProfileMicroservice.dto.UserWrapper;
import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.exceptions.UserAlreadyExists;
import com.scrapbook.UserProfileMicroservice.service.FollowService;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/userProfile")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    FollowService followService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        if(user.getAbout()==null){
            user.setAbout("No About");
        }
        if(user.getDateOfBirth()==null){
            user.setDateOfBirth(new Date());
        }
        if(user.getInterest()==null){
            user.setInterest("No Interest Added");
        }
        if(user.getUserImageURL()==null){
            user.setUserImageURL("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/300px-No_image_available.svg.png");
        }
        User user1 = userService.findOne(user.getUserId());
        if(user1!=null){
            throw new UserAlreadyExists();
        }
        User userCreated = userService.add(user);
        return new ResponseEntity<>(userCreated,HttpStatus.CREATED);

    }

    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = userService.findOne(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User user1 = userService.updateUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/updateUserResp/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<UpdateUserDTO> updateUserDTO(@RequestBody User user){
        User user1 = userService.updateUser(user);
        UpdateUserDTO updateUserDTO;
        if(user1!=null){
            updateUserDTO = new UpdateUserDTO(true,user1);
        }
        else{
            updateUserDTO = new UpdateUserDTO(false,user1);
        }
        return new ResponseEntity<>(updateUserDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserName", method = RequestMethod.GET)
    public UserWrapper getByUserName(@RequestParam String username){
        List<User> user=userService.searchByUserName(username);
        UserWrapper userWrapper=new UserWrapper();
        userWrapper.setUserList(user);
        return userWrapper;
    }

    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteByUserId(@PathVariable String userId){
        userService.deleteByUserId(userId);
        followService.deleteFollowByUserId(userId);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
