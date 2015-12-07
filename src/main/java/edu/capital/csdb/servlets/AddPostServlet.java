package edu.capital.csdb.servlets;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.Post;
import edu.capital.csdb.models.DAO.PostDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to handle adding of posts
 */
@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        Long userId = (Long)req.getSession().getAttribute("user");

        if (userId == null || text == null || text.isEmpty()) {
            req.getSession().setAttribute("error", "an error occurred");
        } else {
            Post post = new Post(text, userId);
            PostDAO postDAO = DAOFactory.getPostDAO();
            postDAO.addPost(post);
        }
        ServletUtil.sendToReferer(req, resp);
    }
}
