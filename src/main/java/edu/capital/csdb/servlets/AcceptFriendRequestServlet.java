package edu.capital.csdb.servlets;

import edu.capital.csdb.models.dataUtil.FriendsHelper;

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
@WebServlet("/acceptFriend")
public class AcceptFriendRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("requestor") != null && req.getParameter("target") != null) {
            Long requestor = Long.parseLong(req.getParameter("requestor"));
            Long target = Long.parseLong(req.getParameter("target"));

            Long requestId = FriendsHelper.getFriendRequestId(requestor, target);

            FriendsHelper.acceptFriendRequest(requestId);

            req.getSession().setAttribute("message", "friend request accepted");
            try {
                URI referer = new URI(req.getHeader("referer"));
                String path = referer.getPath().replace("/", "") + "?" + referer.getQuery();
                resp.sendRedirect(path);
            } catch (URISyntaxException e) {
                resp.sendRedirect("");
            }
        }
    }
}
