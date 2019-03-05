package com.scrapbook.UserProfileMicroservice.entity;/* Made by: mehtakaran9 */


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Follow.TABLE_NAME)
public class Follow {
    public static final String TABLE_NAME = "Follow";
    @Id
    @GeneratedValue(generator ="uuid")
    @GenericGenerator( name="uuid", strategy = "uuid2")
    private String qid;

    private String userId;
    private String followerId;

    public String getUserId() {
        return userId;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "qid='" + qid + '\'' +
                ", userId='" + userId + '\'' +
                ", followerId='" + followerId + '\'' +
                '}';
    }
}
