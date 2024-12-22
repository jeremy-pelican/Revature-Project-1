package com.example.Backend.service;

import com.example.Backend.entity.Follow;
import com.example.Backend.repository.AccountRepository;
import com.example.Backend.repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;
// import java.util.List;
// import java.util.ArrayList;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public FollowService(FollowRepository followRepository, AccountRepository accountRepository) {
        this.followRepository = followRepository;
        this.accountRepository = accountRepository;
    }
    
    public Follow newFollow(Follow follow) {
        if (accountRepository.findById(follow.getFollowerId()).isEmpty()) {
            return null;
        }
        if (accountRepository.findById(follow.getFollowedId()).isEmpty()) {
            return null;
        }
        followRepository.save(follow);
        return follow;
    }

    //consider adding function to get everyone an account follows
}
