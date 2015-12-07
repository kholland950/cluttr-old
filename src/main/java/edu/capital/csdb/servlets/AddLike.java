package edu.capital.csdb.servlets;

import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.Like;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevinholland
 */
@WebServlet("/like")
public class AddLike extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long user = Long.parseLong(req.getParameter("user"));
        Long post = Long.parseLong(req.getParameter("post"));

        Like like = new Like(user, post);
        DAOFactory.getLikeDAO().insertLike(like);
    }
}
