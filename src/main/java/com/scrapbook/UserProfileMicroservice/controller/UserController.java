package com.scrapbook.UserProfileMicroservice.controller;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;
import com.scrapbook.UserProfileMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/userProfile")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
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

    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.DELETE)
    public  ResponseEntity<String> deleteByUserId(@PathVariable String userId){
        System.out.println(userId);
        userService.deleteByUserId(userId);
        return new ResponseEntity<>("Success",HttpStatus.OK);

    }
}
