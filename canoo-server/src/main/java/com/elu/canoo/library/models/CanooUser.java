package com.elu.canoo.library.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class CanooUser {
    @Id private ObjectId _id;

    private String email;
    private String username;
    private String password;
    private CanooUserRoles userRole;

    public CanooUser() {}

    public CanooUser(ObjectId _id, String email, String username, String password, CanooUserRoles userRole) {
        this._id = _id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CanooUserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(CanooUserRoles userRole) {
        this.userRole = userRole;
    }
}
