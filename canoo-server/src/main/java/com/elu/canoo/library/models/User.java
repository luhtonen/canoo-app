package com.elu.canoo.library.models;

import org.springframework.data.annotation.Id;

public class User {
    @Id private String id;

    private String email;
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
