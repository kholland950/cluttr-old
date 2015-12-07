package edu.capital.csdb.servlets;

import edu.capital.csdb.models.Comment;
import edu.capital.csdb.models.DAO.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevinholland
 */
@WebServlet("/addComment")
public class AddComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = (Long)req.getSession().getAttribute("user");
        Long postId = Long.parseLong(req.getParameter("postId"));
        String text = req.getParameter("text");

        Comment comment = new Comment(text, postId, userId);

        DAOFactory.getCommentDAO().insertComment(comment);

        ServletUtil.sendToReferer(req, resp);
    }
}
