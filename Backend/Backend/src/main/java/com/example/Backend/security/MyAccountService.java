package com.example.Backend.security;

import com.example.Backend.entity.Account;
import com.example.Backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class MyAccountService implements UserDetailsService {
    @Autowired private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountRes = accountRepository.findByUsername(username);
        if (accountRes.isEmpty()) throw new UsernameNotFoundException("Could not find account with username = " + username);
        Account account = accountRes.get();
        return new org.springframework.security.core.userdetails.User(
                username,
                account.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ACCOUNT"))
        );
    }
}
