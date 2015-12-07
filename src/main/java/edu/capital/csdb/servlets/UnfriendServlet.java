package edu.capital.csdb.servlets;

import edu.capital.csdb.models.dataUtil.FriendsHelper;

import javax.print.URIException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author kevinholland
 */
@WebServlet("/deleteFriend")
public class UnfriendServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long user = Long.parseLong(req.getParameter("user"));
        Long target = Long.parseLong(req.getParameter("target"));

        FriendsHelper.removeFriend(user, target);

        req.getSession().setAttribute("message", "friend removed");
        try {
            URI referer = new URI(req.getHeader("referer"));
            String path = referer.getPath().replace("/", "") + "?" + referer.getQuery();
            resp.sendRedirect(path);
        } catch (URISyntaxException e) {
            resp.sendRedirect("");
        }
    }
}
