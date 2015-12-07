package edu.capital.csdb.models;

import java.util.Map;

/**
 * User model
 */
public class User {
    private Long userId;
    private String username;

    public User() {}

    public User(Long userId, String username) {
        setUserId(userId);
        setUsername(username);
    }

    public User(Map<String, Object> map) {
        setUserId((Long) map.get("user_id"));
        setUsername((String) map.get("username"));
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
