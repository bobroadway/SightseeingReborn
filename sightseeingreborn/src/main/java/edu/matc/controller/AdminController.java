package edu.matc.controller;

import edu.matc.entity.Sight;
import edu.matc.persistence.SightDao;
import edu.matc.util.Utilities;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Admin page controller.
 * Created on 11/18/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "admin",
        urlPatterns = { "/admin" }
)
public class AdminController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties = Utilities.loadProperties("ssr.properties");

    /**
     * The doGet method for the Admin controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In Admin doGet method.");

        // set title
        request.setAttribute("title", "SSR - Admin");

        // get sights
        SightDao sightDao = new SightDao();
        List<Sight> allSights = sightDao.getAllSights();

        // place allSights into request
        request.setAttribute("allSights", allSights);

        // forward to admin.jsp
        String adminJsp = properties.getProperty("adminJsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher(adminJsp);
        dispatcher.forward(request, response);
    }
}