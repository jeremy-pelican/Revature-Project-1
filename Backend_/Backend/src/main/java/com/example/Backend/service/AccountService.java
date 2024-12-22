package com.example.Backend.service;

import com.example.Backend.entity.Account;
import com.example.Backend.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //need functions to create a user and to log in an existing user
    //chances are, I will need to add custom functions to AccountRepository to grab Accounts by those credentials
    public boolean findUsername(Account account) {
        return accountRepository.findByUsername(account.getUsername()).isPresent();
    }
    public Account newAccount(Account account) {
        // if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
        //     return null; 
        // }
        if (account.getUsername().isEmpty() || account.getPassword().length() < 4) {
            return null;
        }
        accountRepository.save(account);
        return accountRepository.findByUsername(account.getUsername()).get();
    }

    public Account loginAccount(Account account) {
        Optional<Account> optionalAccount = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        return optionalAccount.orElse(null);
    }

    public List<Account> findAccounts(String search) {
        List<Account> accounts = accountRepository.findAll();
        List<Account> matches = new ArrayList<>();
        search = search.toUpperCase();
        for (int i = 0; i < accounts.size(); i++) {
            String uName = accounts.get(i).getUsername().toUpperCase();
            if (uName.contains(search)) {
                matches.add(accounts.get(i));
            }
        }
        return matches;
    }

    public Account updateUsername(int id, String newName) {
        if (newName.isEmpty() || newName == null) {
            return null;
        }
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setUsername(newName);
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    public Account updatePassword(int id, String newPass) {
        if (newPass.length() < 4 || newPass == null) {
            return null;
        }
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setPassword(newPass);
            accountRepository.save(account);
            return account;
        }
        return null;
    }
}