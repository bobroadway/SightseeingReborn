package edu.matc.controller;

import edu.matc.entity.Sight;
import edu.matc.persistence.SightDao;
import edu.matc.persistence.ZoneDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Home page controller.
 * Created on 11/18/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "home",
        urlPatterns = { "", "/home" }
)
public class HomeController extends HttpServlet {
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
        log.info("In Home doGet method");

        // set title
        request.setAttribute("title", "Sightseeing Reborn - Home");

        // get sights
        SightDao sightDao = new SightDao();
        List<Sight> allSights = sightDao.getAllSights();

        // place allSights into request
        request.setAttribute("allSights", allSights);

        // forward to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}