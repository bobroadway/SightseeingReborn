package edu.matc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Home page controller.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "LogOut",
        urlPatterns = { "/logOut" }
)
public class LogOut extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The do get method for the Home controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In LogOut doGet method.");

        // log out
        try {
            log.info("Logging Out.");
            request.logout();
        } catch (ServletException e) {
            log.info("LogOut failed.");
            log.error(e);
        }

        // redirect
        response.sendRedirect("/home");
    }
}