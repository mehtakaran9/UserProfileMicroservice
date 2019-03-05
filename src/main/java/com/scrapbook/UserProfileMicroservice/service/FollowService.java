package com.scrapbook.UserProfileMicroservice.service;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowDTO;
import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import java.util.List;

public interface FollowService {
    Follow add(Follow follow);

    List<Follow> findByFollowerId(String id);

    List<Follow> findByUserId(String followId);

    List<FollowResponseDTO> findFollowersListByUserId(String id);

    List<FollowResponseDTO> findUsersByFollowingId(String id);

    FollowDTO followResponse(String id);

    void deleteByUserIdAndFollowerId(String userId, String followerId);

    void deleteFollowByUserId(String userId);
}
