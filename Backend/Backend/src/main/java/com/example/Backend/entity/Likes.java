package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@NoArgsConstructor
@Entity
@Table(name="likes")
public class Likes {
    @Column (name="likeId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer likeId;

    @Column (name="accountLikes")
    private Integer accountLikes;

    @Column (name="messageLikes")
    private Integer messageLikes;

    public Likes(Integer accountLikes, Integer messageLikes) {
        this.accountLikes = accountLikes;
        this.messageLikes = messageLikes;
    }

    public Likes(Integer likeId, Integer accountLikes, Integer messageLikes) {
        this.likeId = likeId;
        this.accountLikes = accountLikes;
        this.messageLikes = messageLikes;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getAccountLikes() {
        return accountLikes;
    }

    public void setAccountLikes(Integer accountLikes) {
        this.accountLikes = accountLikes;
    }

    public Integer getMessageLikes() {
        return messageLikes;
    }

    public void setMessageLikes(Integer messageLikes) {
        this.messageLikes = messageLikes;
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
        Likes other = (Likes) obj;
        if (likeId == null) {
            if (other.likeId != likeId) {
                return false;
            }
        }
        else if (!likeId.equals(other.likeId)) {
            return false;
        }
        if (accountLikes == null) {
            if (other.accountLikes != null) {
                return false;
            } 
        }
        else if (!accountLikes.equals(other.accountLikes)) {
            return false;
        }
        if (messageLikes == null) {
            if (other.messageLikes != null) {
                return false;
            }
        }
        else if (!messageLikes.equals(other.messageLikes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Likes{" +
        "likeId=" + likeId +
        ", accountLikes=" + accountLikes +
        ", messageLikes=" + messageLikes +
        '}'; 
    }
}
