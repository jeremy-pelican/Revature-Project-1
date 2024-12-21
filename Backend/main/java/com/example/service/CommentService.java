package java.com.example.service;

import java.com.example.entity.Comment;
import java.com.example.repository.CommentRepository;
import java.com.example.repository.AccountRepository;
import java.com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private MessageRepository messageRepository;
    private AccountRepository accountRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MessageRepository messageRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Comment newComment(Comment comment) {
        if (comment.getCommentText().length() < 1 || comment.getCommentText().length() > 255) {
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
        if (newText == null || newText.length() == 0 || newText.length() > 255) {
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
