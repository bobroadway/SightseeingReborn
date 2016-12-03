package edu.matc.service;

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
        name = "LogIn",
        urlPatterns = { "/logIn" }
)
public class LogIn extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The do get method for the Home controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In LogIn doPost method.");

        // declare variables
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // log in
        try {
            request.login(username, password);
            log.info("Logged in as " + username);

            // redirect
            response.sendRedirect("/home");
        } catch (ServletException e) {
            log.error(e);

            // redirect
            response.sendRedirect("/login_error.jsp");
        }


    }
}