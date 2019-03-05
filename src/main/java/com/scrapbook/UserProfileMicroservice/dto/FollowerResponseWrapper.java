package com.scrapbook.UserProfileMicroservice.dto;/* Made by: mehtakaran9 */

import java.util.List;

public class FollowerResponseWrapper {
    List<FollowResponseDTO> followResponseDTOList;

    public List<FollowResponseDTO> getFollowResponseDTOList() {
        return followResponseDTOList;
    }

    public void setFollowResponseDTOList(List<FollowResponseDTO> followResponseDTOList) {
        this.followResponseDTOList = followResponseDTOList;
    }

    @Override
    public String toString() {
        return "FollowerResponseWrapper{" +
                "followResponseDTOList=" + followResponseDTOList +
                '}';
    }
}
