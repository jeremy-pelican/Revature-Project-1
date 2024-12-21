package java.com.example.controller;

import java.com.example.entity.Account;
import java.com.example.entity.Message;
import java.com.example.entity.Likes;
import java.com.example.entity.Comment;
import java.com.example.entity.Follow;

import java.com.example.service.AccountService;
import java.com.example.service.MessageService;
import java.com.example.service.LikesService;
import java.com.example.service.CommentService;
import java.com.example.service.FollowService;


import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SocialMediaController {
    private AccountService accountService;
    private MessageService messageService;
    private LikesService likesService;
    private CommentService commentService;
    private FollowService followService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService,  LikesService likesService, CommentService commentService, FollowService followService) {
        this.accountService = accountService;
        this.messageService = messageService;
        this.likesService = likesService;
        this.commentService = commentService;
        this.followService = followService;
    }

    //@PostMapping("/register") to register new Account
    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        if (accountService.findUsername(account)) {
            return ResponseEntity.status(409).body(null);
        }
        Account acc = accountService.newAccount(account);
        if (acc == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(acc);
    }

    //@PostMapping("/login") to verify Account login
    @PostMapping("/login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
        Account acc = accountService.loginAccount(account);
        if (acc == null) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.status(200).body(acc);
    }

    //@PostMapping("/messages") to create new message
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message msg = messageService.newMessage(message);
        if (msg == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(msg);
    }

    //@GetMapping("/messages") to get all messages
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.status(200).body(messageService.getAllMessages());
    }

    //@GetMapping("/messages/{messageId}") to get message by its ID
    @GetMapping("/messages/{messageId}")
    public ResponseEntity<Message> getMessageByID(@PathVariable int messageId) {
        return ResponseEntity.status(200).body(messageService.getMessageByID(messageId));
    }

    //@DeleteMapping("/messages/{messageId}") to delete message by its ID
    @DeleteMapping("/messages/{messageId}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable int messageId) {
        Message message = messageService.deleteMessage(messageId);
        if (message == null) {
            return ResponseEntity.status(200).body(null);
        }
        return ResponseEntity.status(200).body(1);
    }

    //@PatchMapping("/messages/{messageId}") to update message by its ID
    @PatchMapping("/messages/{messageId}")
    public ResponseEntity<Integer> updateMessage(@PathVariable int messageId, @RequestBody Message message) {
        Message msg = messageService.updateMessage(messageId, message.getMessageText());
        if (msg == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(1);
    }

    //@GetMapping("/accounts/{accountId}/messages") to get all messages written by a user
    @GetMapping("/accounts/{accountId}/messages")
    public ResponseEntity<List<Message>> getMessagesFromUser(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(messageService.getMessagesFromUser(accountId));
    }

    /*
    TODO: Add methods for additions to Service files
    Lists should be @GetMapping, updates should be @PatchMapping
    */
    @GetMapping("search/accounts")
    public ResponseEntity<List<Account>> searchAccounts(@RequestBody String search) {
        return ResponseEntity.status(200).body(accountService.findAccounts(search));
    }

    @GetMapping("search/messages/{search}")
    public ResponseEntity<List<Message>> searchMessages(@RequestBody String search) {
        return ResponseEntity.status(200).body(messageService.findMessages(search));
    }

    @PatchMapping("/accounts/{id}")
    public ResponseEntity<Integer> updateAccountUsername(@PathVariable int accountId, @RequestBody Account account) {
        Account acct = accountService.updateUsername(accountId, account.getUsername());
        if (acct == null) {
            return ResponseEntity.status(400).body(null);
        } 
        return ResponseEntity.status(200).body(1);
    }

    @PatchMapping("/accounts/{id}")
    public ResponseEntity<Integer> updateAccountPassword(@PathVariable int accountId, @RequestBody Account account) {
        Account acct = accountService.updatePassword(accountId, account.getPassword());
        if (acct == null) {
            return ResponseEntity.status(400).body(null);
        } 
        return ResponseEntity.status(200).body(1);
    }

    @PostMapping("/messages/comments") 
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment cmt = commentService.newComment(comment);
        if (cmt == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(cmt);
    }

    @DeleteMapping("/messages/comments/{commentId}")
    public ResponseEntity<Integer> deleteComment(@PathVariable int commentId) {
        Comment comment = commentService.deleteComment(commentId);
        if (comment == null) {
            return ResponseEntity.status(200).body(null);
        }
        return ResponseEntity.status(200).body(1);
    }

    @PatchMapping("/messages/comments/{commentId}")
    public ResponseEntity<Integer> updateComment(@PathVariable int commentId, @RequestBody Comment comment) {
        Comment cmt = commentService.updateComment(commentId, comment.getCommentText());
        if (cmt == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(1);
    }

    @GetMapping("/messages/{messageId}/comments") 
    public ResponseEntity<List<Comment>> getCommentsFromMessage(@PathVariable int messageId) {
        return ResponseEntity.status(200).body(commentService.getMessageComments(messageId));
    }

    @PostMapping("/accounts/follow")
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow) {
        Follow flw = followService.newFollow(follow);
        if (flw == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(flw);
    }

    @PostMapping("/messages/like") 
    public ResponseEntity<Likes> createLike(@RequestBody Likes like) {
        Likes lk = likesService.newLike(like);
        if (lk == null) {
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(lk);
    }
}