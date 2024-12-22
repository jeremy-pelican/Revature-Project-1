package com.example.Backend.service;

import com.example.Backend.entity.Likes;
import com.example.Backend.repository.AccountRepository;
import com.example.Backend.repository.LikesRepository;
import com.example.Backend.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;
// import java.util.List;
// import java.util.ArrayList;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public LikesService(LikesRepository likesRepository, MessageRepository messageRepository, AccountRepository accountRepository) {
        this.likesRepository = likesRepository;
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Likes newLike(Likes like) {
        if (messageRepository.findById(like.getMessageLikes()).isEmpty()) {
            return null;
        }
        if (accountRepository.findById(like.getAccountLikes()).isEmpty()) {
            return null;
        }
        likesRepository.save(like);
        return like;
    }
}
