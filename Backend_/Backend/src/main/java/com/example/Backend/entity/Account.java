package com.example.Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Column(name="accountId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    private String username;

    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(Integer accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        if (accountId == null) {
            if (other.accountId != null) {
                return false;
            }
        }
        else if (!accountId.equals(other.accountId)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        }
        else if (!password.equals(other.password)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        }
        else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + 
        "accountId=" + accountId +
        ", username='" + username + '\'' +
        ", password='" + password +'\'' +
        '}';
    }
}
