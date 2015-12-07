package edu.capital.csdb.models.dataUtil;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.DAO.UserDAO;

/**
 * Created by kevinholland on 12/1/15.
 */
public class UserUtil {
    public static String getUsername(Long id) {
        UserDAO userDAO = DAOFactory.getUserDAO();
        return userDAO.getUser(id).getUsername();
    }
}
