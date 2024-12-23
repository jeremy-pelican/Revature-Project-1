package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@NoArgsConstructor
@Entity
@Table(name="comment")
public class Comment {
    @Column (name="commentId")
    @Id @GeneratedValue
    private Integer commentId;

    @Column (name="sentBy")
    private Integer sentBy;

    @Column (name="replyTo")
    private Integer replyTo;
    
    @Column (name="commentText")
    private String commentText;

    public Comment(int sentBy, int replyTo, String commentText) {
        this.sentBy = sentBy;
        this.replyTo = replyTo;
        this.commentText = commentText;
    }

    public Comment(int commentId, int sentBy, int replyTo, String commentText) {
        this.commentId = commentId;
        this.sentBy = sentBy;
        this.replyTo = replyTo;
        this.commentText = commentText;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getSentBy() {
        return sentBy;
    }

    public void setSentBy(Integer sentBy) {
        this.sentBy = sentBy;
    }

    public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Comment other = (Comment) obj;
        if (commentId == null) {
            if (other.commentId != null) {
                return false;
            }
        }
        else if (!commentId.equals(other.commentId)) {
            return false;
        }
        if (sentBy == null) {
            if (other.sentBy != null) {
                return false;
            }
        }
        else if (!sentBy.equals(other.sentBy)) {
            return false;
        }
        if (replyTo == null) {
            if (other.replyTo != null) {
                return false;
            }
        }
        else if (!replyTo.equals(other.replyTo)) {
            return false;
        }
        if (commentText == null) {
            if (other.commentText != null) {
                return false;
            }
        }
        else if (!commentText.equals(other.commentText)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" +
        ", commentId=" + commentId +
        ", sentBy=" + sentBy +
        ", replyTo=" + replyTo +
        ", commentText='" + commentText + '\'' +
        '}';
    }
}