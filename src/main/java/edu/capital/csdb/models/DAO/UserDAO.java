package edu.capital.csdb.models.DAO;


import edu.capital.csdb.models.User;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Data access object for Users
 */
public class UserDAO extends DAO {
    public UserDAO(DataSource dataSource) {
        super(dataSource);
    }

    public Long insertUser(User user) {
        String sql = "INSERT INTO user (username) VALUES( ? )";
        jdbcTemplate.update(sql, user.getUsername());

        sql = "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1;";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public boolean userExists(String username) {
        return getUser(username) != null;
    }

    public User getUser(Long id) {
        final String sql = "SELECT * FROM user WHERE user_id = ?";
        return queryForUser(sql, id);
    }

    public User getUser(String username) {
        final String sql = "SELECT * FROM user WHERE username = ?";
        return queryForUser(sql, username);
    }

    private User queryForUser(String sql, Object... args) {
        try {
            Map<String, Object> row = jdbcTemplate.queryForMap(sql, args);
            User user = new User();
            user.setUserId((Long) row.get("user_id"));
            user.setUsername((String) row.get("username"));
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
