package edu.capital.csdb.models;

import edu.capital.csdb.models.dataUtil.CommentUtil;
import edu.capital.csdb.models.dataUtil.LikeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Post model
 */
public class Post {
    private Long postId;
    private String text;
    private Long userId;
    public List<Comment> comments = new ArrayList<>();
    public List<User> likes = new ArrayList<>();

    public Post() {}

    public Post(String text, Long userId) {
        setText(text);
        setUserId(userId);
    }

    public Post(Map<String, Object> map) {
        setPostId((Long)map.get("id"));
        setText((String)map.get("text"));
        setUserId((Long)map.get("user"));

        likes = LikeUtil.postLikes(postId);
        comments = CommentUtil.postComments(postId);
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
