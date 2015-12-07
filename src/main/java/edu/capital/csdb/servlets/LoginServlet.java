package edu.capital.csdb.servlets;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to handle login in
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserDAO userDAO = DAOFactory.getUserDAO();

        if (userDAO.userExists(username)) {
            //login is successful
            req.getSession().setAttribute("user", userDAO.getUser(username).getUserId());
            resp.sendRedirect("/");
        } else {
            //username does not exist
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("error", "this username does not exist");
            resp.sendRedirect("/login.jsp");
        }
    }
}
