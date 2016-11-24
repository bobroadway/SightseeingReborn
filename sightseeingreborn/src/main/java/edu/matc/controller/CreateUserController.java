package edu.matc.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create User page controller.
 * Created on 11/18/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "createUser",
        urlPatterns = { "/createUser" }
)
public class CreateUserController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The do get method for the createUser controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In CreateUser doGet method.");

        // set title
        request.setAttribute("title", "Create Login");

        // forward to createUser.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createUser.jsp");
        dispatcher.forward(request, response);
    }
}