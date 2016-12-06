package edu.matc.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import edu.matc.util.Utilities;
import org.apache.log4j.Logger;

/**
 * Service to log a user IN.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "LogIn",
        urlPatterns = { "/logIn" }
)
public class LogIn extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties = Utilities.loadProperties("ssr.properties");

    /**
     * The doGet method for LogIn. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In LogIn doPost method.");

        // declare variables
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // log in
        try {
            request.login(userName, password);
            log.info("Logged in as " + userName);

            // redirect to home
            String home = properties.getProperty("home");
            response.sendRedirect(home);
        } catch (ServletException e) {
            log.error(e);

            // redirect to login_error
            String loginErrorJsp = properties.getProperty("loginErrorJsp");
            response.sendRedirect(loginErrorJsp);
        }

    }
}