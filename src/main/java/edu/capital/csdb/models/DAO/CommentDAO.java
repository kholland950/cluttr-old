package edu.capital.csdb.models.DAO;

import edu.capital.csdb.models.Comment;

import javax.sql.DataSource;

/**
 * @author kevinholland
 */
public class CommentDAO extends DAO {
    public CommentDAO(DataSource dataSource) {
        super(dataSource);
    }

    public void insertComment(Comment comment) {
        final String sql = "INSERT INTO comment (text, post, user) " +
                "VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, comment.getText(), comment.getPostId(), comment.getUserId());
    }
}
