package java.com.example.service;

import java.com.example.entity.Likes;
import java.com.example.repository.AccountRepository;
import java.com.example.repository.LikesRepository;
import java.com.example.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;
// import java.util.List;
// import java.util.ArrayList;

@Service
public class LikesService {
    private LikesRepository likesRepository;
    private MessageRepository messageRepository;
    private AccountRepository accountRepository;

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
