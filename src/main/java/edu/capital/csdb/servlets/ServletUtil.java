package edu.capital.csdb.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author kevinholland
 */
public class ServletUtil {
    public static void sendToReferer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            URI referer = new URI(req.getHeader("referer"));
            String path = referer.getPath().replace("/", "");
            if (referer.getQuery() != null) {
                path +=  "?" + referer.getQuery();
            }
            resp.sendRedirect(path);
        } catch (URISyntaxException e) {
            resp.sendRedirect("");
        }
    }
}
