package com.scrapbook.UserProfileMicroservice.repository;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.dto.FollowResponseDTO;
import com.scrapbook.UserProfileMicroservice.entity.Follow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, String> {
    List<Follow> findByUserId(String followId);

    List<Follow> findByFollowerId(String followerId);

    @Query(value = "SELECT follow.follower_id, user_profile.username, user_profile.user_imageurl FROM user_profile LEFT JOIN follow ON user_profile.user_id = follow.user_id WHERE follow.user_id = :id", nativeQuery = true)
    List<FollowResponseDTO> findListByFollowId(@Param("id") String id);

}
