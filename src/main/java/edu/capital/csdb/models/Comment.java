package edu.capital.csdb.models;

import java.util.Map;

/**
 * Comment model
 */
public class Comment {
    private Long id;
    private String text;
    private Long postId;
    private Long userId;

    public Comment() {}

    public Comment(String text, Long postId, Long userId) {
        this.text = text;
        this.postId = postId;
        this.userId = userId;
    }

    public Comment(Map<String, Object> row) {
        this.text = (String)row.get("text");
        this.postId = (Long)row.get("post");
        this.userId = (Long)row.get("user");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
