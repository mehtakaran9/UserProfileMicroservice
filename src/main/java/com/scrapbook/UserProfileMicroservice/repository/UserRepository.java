package com.scrapbook.UserProfileMicroservice.repository;/* Made by: mehtakaran9 */

import com.scrapbook.UserProfileMicroservice.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM user_profile WHERE username iLIKE %:username%",nativeQuery = true)
    List<User> findByUsernameIgnoreCase(@Param("username") String username);
}
