package edu.capital.csdb.servlets;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.User;
import edu.capital.csdb.models.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevinholland
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserDAO userDAO = DAOFactory.getUserDAO();
        if (userDAO.userExists(username)) {
            //user exists
            req.getSession().setAttribute("error", "this username is already in use");
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/signup.jsp");
        } else {
            //username is available
            User user = new User();
            user.setUsername(username);
            Long userId = userDAO.insertUser(user);
            req.getSession().setAttribute("user", userId);
            resp.sendRedirect("/");
        }
    }
}
