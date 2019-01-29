package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.Follow;

import java.util.List;

public interface FollowService {
    Follow add(Follow follow);

    void unfollow(String followId, String followerId);

    List<String> getAllFollowers(String followId);
}
