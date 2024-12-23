package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@NoArgsConstructor
@Entity
@Table(name="follow")
public class Follow {
    @Column (name="followId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer followId;

    @Column (name="followerId")
    private Integer followerId;

    @Column (name="followedId")
    private Integer followedId;

    public Follow(Integer followerId, Integer followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    public Follow(Integer followId, Integer followerId, Integer followedId) {
        this.followId = followId;
        this.followerId = followerId;
        this.followedId = followedId;
    }
    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Integer getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Follow other = (Follow) obj;
        if (followId == null) {
            if (other.followId != null) {
                return false;
            }
        }
        else if (!followId.equals(other.followId)) {
            return false;
        }
        if (followerId == null) {
            if (other.followerId != null) {
                return false;
            }
        }
        else if (!followerId.equals(other.followerId)) {
            return false;
        }
        if (followedId == null) {
            if (other.followedId != null) {
                return false;
            }
        }
        else if (!followedId.equals(other.followedId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Follow{" +
        "followId=" + followId +
        ", followerId=" + followerId +
        ", followedId=" + followedId +
        '}';
    }
}
