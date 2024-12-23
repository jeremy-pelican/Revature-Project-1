package com.example.Backend.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


