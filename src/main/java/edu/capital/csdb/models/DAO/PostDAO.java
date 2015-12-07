package edu.capital.csdb.models.DAO;

import edu.capital.csdb.models.Post;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kevinholland
 */
public class PostDAO extends DAO {
    public PostDAO(DataSource dataSource) {
        super(dataSource);
    }

    public Long addPost(Post post) {
        final String sql = "INSERT INTO post (text, user) " +
                "VALUES (?, ?) ";
        jdbcTemplate.update(sql, post.getText(), post.getUserId());

        final String select = "SELECT id FROM post ORDER BY id DESC LIMIT 1;";
        return jdbcTemplate.queryForObject(select, Long.class);
    }

    public Post getPost(Long postId) {
        final String sql = "SELECT * FROM post WHERE id=?";
        Map<String, Object> row = jdbcTemplate.queryForMap(sql, postId);
        return new Post(row);
    }

    public List<Post> getAllRelatedPosts(Long userId) {
        final String sql = "SELECT * FROM post WHERE user=? OR user IN " +
                "(SELECT user1 FROM friends WHERE user2=? " +
                "UNION SELECT user2 FROM friends WHERE user1=?) " +
                "ORDER BY id DESC;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, userId, userId, userId);
        List<Post> posts = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            posts.add(new Post(row));
        }
        return posts;
    }


    public List<Post> getUserPosts(Long userId) {
        final String sql = "SELECT * FROM post WHERE user=? ORDER BY id DESC";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, userId);
        List<Post> posts = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            posts.add(new Post(row));
        }
        return posts;
    }
}
