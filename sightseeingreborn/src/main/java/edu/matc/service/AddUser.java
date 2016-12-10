package edu.matc.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
import edu.matc.util.Utilities;
import org.apache.log4j.Logger;

/**
 * Service to add a user to the USER table.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "AddUser",
        urlPatterns = { "/addUser" }
)
public class AddUser extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties = Utilities.loadProperties("ssr.properties");

    /**
     * The doGet method for the Home controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In AddUser doPost method.");

        // Daos for USER and USER_ROLE
        UserDao userDao = new UserDao();
        UserRoleDao userRoleDao = new UserRoleDao();

        // assign user variables
        String userName = request.getParameter("newUsername");
        String password = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        log.info(userName + " | " + password + " | " + confirmPassword);

        // instantiate new User and UserRole for the user
        User user = new User(userName, password);
        UserRole userRole = new UserRole(userName);

        // add user to database
        if (password.equals(confirmPassword) && (userDao.getUser(userName) == null)) {

            // add user to USER table and USER_ROLE table
            userDao.addUser(user);
            userRoleDao.addUserRole(userRole);
            log.info("User: " + userName + " created.");

            // log in
            try {
                request.login(userName, password);
                log.info("Created User: " + userName + " now logged in.");

                // redirect to home
                String home = properties.getProperty("home");
                response.sendRedirect(request.getContextPath() + home);
            } catch (ServletException e) {
                log.error(e);

                // redirect to login_error
                String loginErrorJsp = properties.getProperty("loginErrorJsp");
                response.sendRedirect(loginErrorJsp);
            }

        } else {
            log.info("Passwords: " + password + " v. " + confirmPassword);
            log.info("User exists: " + (userDao.getUser(userName) == null));
        }

    }

}