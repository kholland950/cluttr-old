package edu.capital.csdb.models.dataUtil;

import edu.capital.csdb.models.Comment;
import edu.capital.csdb.models.DAO.DataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kevinholland on 12/6/15.
 */
public class CommentUtil {
    public static List<Comment> postComments(Long postId) {
        final String sql = "SELECT * FROM comment WHERE post=?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, postId);
        List<Comment> comments = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            comments.add(new Comment(row));
        }

        return comments;
    }
}
