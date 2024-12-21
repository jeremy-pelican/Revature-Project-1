package java.com.example.service;

import java.com.example.entity.Follow;
import java.com.example.repository.AccountRepository;
import java.com.example.repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.Optional;
// import java.util.List;
// import java.util.ArrayList;

@Service
public class FollowService {
    private FollowRepository followRepository;
    private AccountRepository accountRepository;

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
