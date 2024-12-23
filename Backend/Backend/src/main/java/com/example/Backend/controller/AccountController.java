package com.example.Backend.controller;

import com.example.Backend.entity.Account;
import com.example.Backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountRepository accountRepository;

    @GetMapping("/info")
    public Account getAccountDetails() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return accountRepository.findByUsername(username).get();
    }
}
