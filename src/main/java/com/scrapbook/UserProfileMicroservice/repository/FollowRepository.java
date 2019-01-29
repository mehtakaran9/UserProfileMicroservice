package com.scrapbook.UserProfileMicroservice.repository;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.Follow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, String> {
    List<Follow> findByFollowId(String followId);

    @Query(value = "DELETE FROM Follow where Follow.followId = ?1 AND Follow.followerId = ?2", nativeQuery = true)
    void unfollow(String followId, String followerId);

    List<Follow> findByFollowerId(String followerId);
}
