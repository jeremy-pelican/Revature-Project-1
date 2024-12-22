package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Backend.entity.Comment;
import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer>{
    List<Comment> findAllByReplyTo(int replyTo);
}
