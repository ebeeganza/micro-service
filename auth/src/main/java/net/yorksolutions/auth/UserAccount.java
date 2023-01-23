package net.yorksolutions.auth;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue
    UUID id;

    String username;

    String password;
    public UserAccount(){}
    public UserAccount(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
