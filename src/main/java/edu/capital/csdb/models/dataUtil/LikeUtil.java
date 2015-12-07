package edu.capital.csdb.models.dataUtil;

import edu.capital.csdb.models.DAO.DataSourceFactory;
import edu.capital.csdb.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kevinholland on 12/6/15.
 */
public class LikeUtil {
    public static boolean userLikesPost(Long userId, Long postId) {
        final String sql = "SELECT COUNT(*) FROM likes " +
                "WHERE user=? AND post=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        int like = jdbcTemplate.queryForObject(sql, Integer.class, userId, postId);
        return like == 1;
    }

    public static List<User> postLikes(Long postId) {
        final String sql = "SELECT * FROM user WHERE user_id IN " +
                "(SELECT user FROM likes WHERE post=?);";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, postId);
        List<User> users = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            users.add(new User((row)));
        }

        return users;
    }
}
