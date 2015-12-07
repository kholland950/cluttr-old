package edu.capital.csdb.models.DAO;

import edu.capital.csdb.models.Like;

import javax.sql.DataSource;

/**
 * @author kevinholland
 */
public class LikeDAO extends DAO {
    public LikeDAO(DataSource dataSource) {
        super(dataSource);
    }

    public void insertLike(Like like) {
        final String sql = "INSERT INTO likes (user, post) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, like.getUserId(), like.getPostId());
    }
}
