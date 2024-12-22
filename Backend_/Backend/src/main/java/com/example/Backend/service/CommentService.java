package com.example.Backend.service;

import com.example.Backend.entity.Comment;
import com.example.Backend.repository.CommentRepository;
import com.example.Backend.repository.AccountRepository;
import com.example.Backend.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MessageRepository messageRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Comment newComment(Comment comment) {
        if (comment.getCommentText().isEmpty() || comment.getCommentText().length() > 255) {
            return null;
        }
        if (messageRepository.findById(comment.getReplyTo()).isEmpty()) {
            return null;
        }
        if (accountRepository.findById(comment.getSentBy()).isEmpty()) {
            return null;
        }
        commentRepository.save(comment);
        return comment;
    }

    public Comment deleteComment(int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            commentRepository.deleteById(id);
            return optionalComment.get();
        }
        return null;
    }

    public Comment updateComment(int id, String newText) {
        if (newText == null || newText.isEmpty() || newText.length() > 255) {
            return null;
        }
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setCommentText(newText);
            commentRepository.save(comment);
            return comment;
        }
        return null;
    }

    public List<Comment> getMessageComments(int replyTo) {
        return (List<Comment>) commentRepository.findAllByReplyTo(replyTo);    }
}
