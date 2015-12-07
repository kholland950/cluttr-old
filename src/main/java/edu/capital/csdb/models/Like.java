package edu.capital.csdb.models;

/**
 * Created by kevinholland on 12/6/15.
 */
public class Like {
    private Long userId;
    private Long postId;

    public Like() {}

    public Like(Long userId, Long postId) {
        setUserId(userId);
        setPostId(postId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
