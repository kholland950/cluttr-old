package edu.capital.csdb.models.dataUtil;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.DAO.DataSourceFactory;
import edu.capital.csdb.models.User;
import edu.capital.csdb.models.DAO.UserDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kevinholland
 */
public class FriendsHelper {
    /**
     * num friends
     * SELECT COUNT(*) FROM friends WHERE user1=3 OR user2=3;
     *
     * find all friends from userid
     * SELECT userid FROM (SELECT user2 as userid FROM friends WHERE user1=3
     * UNION SELECT user1 as userid FROM friends WHERE user2=3) as friendtable;
     *
     * check if two people are friends, returns 1 if so
     * SELECT COUNT(*) FROM friends WHERE user1=3 AND user2=5 OR user1=5 and user2=3;
     *
     * find all users not friends with user
     * SELECT DISTINCT * FROM user WHERE user_id!=3 AND user_id NOT IN
     * (SELECT user_id FROM
     * (SELECT user2 as user_id FROM friends WHERE user1=3
     * UNION SELECT user1 as user_id FROM friends WHERE user2=3) as friendtable
     * UNION SELECT target as user_id FROM friendRequests WHERE requestor=3 OR target=3);
     */

    public static void makeFriendRequest(Long requestor, Long target) {
        final String sql = "INSERT INTO friendRequests (requestor, target) VALUES (?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        jdbcTemplate.update(sql, requestor, target);
    }

    public static void acceptFriendRequest(Long requestId) {
        final String acceptRequest = "INSERT INTO friends (user1, user2) " +
                "SELECT requestor, target FROM friendRequests WHERE request_id=?;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        jdbcTemplate.update(acceptRequest, requestId);

        final String deleteRequest = "DELETE FROM friendRequests WHERE request_id=?;";

        jdbcTemplate.update(deleteRequest, requestId);
    }

    public static Long getFriendRequestId(Long requestor, Long target) {
        final String sql = "SELECT request_id FROM friendRequests WHERE requestor=? AND target=?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        return jdbcTemplate.queryForObject(sql, Long.class, requestor, target);
    }

    public static boolean friendRequestExists(Long requestor, Long target) {
        final String sql = "SELECT COUNT(*) FROM friendRequests WHERE requestor=? AND target=?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        int numRequests = jdbcTemplate.queryForObject(sql, Integer.class, requestor, target);

        return numRequests == 1;
    }

    public static List<User> getFriendRequests(Long target) {
        final String sql = "SELECT * FROM user WHERE user_id IN " +
                "(SELECT requestor FROM friendRequests WHERE target=?);";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, target);

        List<User> users = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            users.add(new User(row));
        }

        return users;
    }

    public static void removeFriend(Long user, Long target) {
        final String sql = "DELETE FROM friends WHERE user1=? AND user2=?;";

        //user1 should be less than user2
        Long user1 = user < target ? user : target;
        Long user2 = user > target ? user : target;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        jdbcTemplate.update(sql, user1, user2);
    }

    /**
     *
     * @param id
     * @return
     */
    public static List<User> getUsersNotRelatedTo(Long id) {
        final String sql = "SELECT DISTINCT * FROM user WHERE user_id!=? AND user_id NOT IN " +
                "(SELECT user_id FROM " +
                "(SELECT user2 AS user_id FROM friends WHERE user1=? " +
                "UNION SELECT user1 AS user_id FROM friends WHERE user2=?) AS friendtable " +
                "UNION SELECT target AS user_id FROM friendRequests WHERE requestor=? " +
                "UNION SELECT requestor AS user_id FROM friendRequests WHERE target=?);";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id, id, id, id, id);
        UserDAO userDAO = DAOFactory.getUserDAO();

        List<User> users = new ArrayList<User>();

        for (Map<String, Object> row : rows) {
            users.add(userDAO.getUser((Long)row.get("user_id")));
        }

        return users;
    }

    public static List<User> getAllFriends(Long id) {
        final String sql = "SELECT * FROM " +
                "(SELECT user2 as user_id FROM friends WHERE user1=? " +
                "UNION SELECT user1 as user_id FROM friends WHERE user2=?) as friendtable;";

        List<User> users = new ArrayList<User>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id, id);

        UserDAO userDAO = DAOFactory.getUserDAO();
        for (Map<String, Object> row : rows) {
            users.add(userDAO.getUser((Long)row.get("user_id")));
        }
        return users;
    }

    public static boolean areFriends(Long user1, Long user2) {
        final String sql = "SELECT COUNT(*) FROM friends WHERE user1= ? AND user2= ? or user1= ? AND user2= ? ;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceFactory.getDataSource());
        int friends = jdbcTemplate.queryForObject(sql, new Object[] {user1, user2, user2, user1}, Integer.class);
        return friends == 1;
    }
}
