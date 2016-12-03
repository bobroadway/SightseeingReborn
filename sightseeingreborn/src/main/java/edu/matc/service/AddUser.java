package edu.matc.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
import org.apache.log4j.Logger;

/**
 * Home page controller.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "AddUser",
        urlPatterns = { "/addUser" }
)
public class AddUser extends HttpServlet {
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
        log.info("In AddUser doPost method.");

        // declare variables
        UserDao userDao = new UserDao();
        UserRoleDao userRoleDao = new UserRoleDao();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        log.info(username + " " + password + " " + confirmPassword);

        User user = new User(username, password);
        UserRole userRole = new UserRole(username);

        // add user to database
        if (username != null && password != null && confirmPassword != null
                && password.equals(confirmPassword) && !username.equals(userDao.getUser(username))) {
            userDao.addUser(user);
            userRoleDao.addUserRole(userRole);
            log.info("User: " + username + " created.");

            // log in
            try {
                request.login(username, password);
                log.info("Created User: " + username + " now logged in.");

                // redirect
                response.sendRedirect("/home");
            } catch (ServletException e) {
                log.error(e);

                // redirect
                response.sendRedirect("/login_error.jsp");
            }

        } else {
            log.info("Passwords: " + password + " v. " + confirmPassword);
            log.info("User exists: " + username.equals(userDao.getUser(username)));
        }




    }
}