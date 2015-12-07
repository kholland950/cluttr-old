package edu.capital.csdb.models.DAO;

/**
 * @author kevinholland
 */
public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new UserDAO(DataSourceFactory.getDataSource());
    }
    public static PostDAO getPostDAO() {
        return new PostDAO(DataSourceFactory.getDataSource());
    }
    public static LikeDAO getLikeDAO() {
        return new LikeDAO(DataSourceFactory.getDataSource());
    }
    public static CommentDAO getCommentDAO() {
        return new CommentDAO(DataSourceFactory.getDataSource());
    }
}
