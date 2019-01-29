package com.scrapbook.UserProfileMicroservice.entity;/* Made by: mehtakaran9 */


import javax.persistence.*;

@Entity
@Table(name = Follow.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(columnNames = "followId"),
        @UniqueConstraint(columnNames = "followId")})
public class Follow {
    public static final String TABLE_NAME = "Follow";
    public static final String ID_COLUMN = "followId";
    @Id
    @Column(name = ID_COLUMN)
    private String followId;
    private String followerId;

    public String getFollowId() {
        return followId;
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
                "followId='" + followId + '\'' +
                ", followerId='" + followerId + '\'' +
                '}';
    }
}
