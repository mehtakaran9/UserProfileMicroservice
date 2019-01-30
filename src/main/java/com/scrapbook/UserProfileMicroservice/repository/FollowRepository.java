package com.scrapbook.UserProfileMicroservice.repository;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.Follow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, String> {
    List<Follow> findByUserId(String followId);

    @Query(value = "Select p.user_id, p.user_imageurl, p.username from user_profile p, follow f where p.user_id=f.follower_id AND f.user_id=:id", nativeQuery = true)
    List<Object[]> findFollowersListByUserId(@Param("id") String id);

    @Query(value = "Select p.user_id, p.user_imageurl, p.username from user_profile p, follow f where p.user_id=f.user_id AND f.follower_id=:id", nativeQuery = true)
    List<Object[]> findUsersByFollowerId(@Param("id") String id);


    List<Follow> findByFollowerId(String followerId);
}
