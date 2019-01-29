package com.scrapbook.UserProfileMicroservice.entity;/* Made by: mehtakaran9 */


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = Follow.TABLE_NAME)
public class Follow {
    public static final String TABLE_NAME = "Follow";
//    public static final String ID_COLUMN = "followId";
    @Id
    @GeneratedValue(generator ="uuid")                 // hibernate
    @GenericGenerator( name="uuid", strategy = "uuid2")
    private String qid;
    @ManyToMany
    @JoinColumn(name="user_id")

    private String followId;
    private String followerId;

    public String getFollowId() {
        return followId;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
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
                ", followId='" + followId + '\'' +
                ", followerId='" + followerId + '\'' +
                '}';
    }
}
