package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;

import java.util.List;

public interface FollowService {
    Follow add(Follow follow);

    List<Follow> findByFollowerId(String id);

    List<Follow> findByUserId(String followId);

    List<Object> findFollowersListByUserId(String id);

    List<Object> findUsersByFollowingId(String id);

    FollowDTO followResponse(String id);
}
