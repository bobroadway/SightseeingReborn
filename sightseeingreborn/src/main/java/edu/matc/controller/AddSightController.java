package edu.matc.controller;

import edu.matc.entity.Zone;
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
 * Add Sight page controller.
 * Created on 11/18/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "addSight",
        urlPatterns = { "/addSight" }
)
public class AddSightController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The do get method for the Add Sight controller. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In AddSight doGet method.");

        // set title
        request.setAttribute("title", "Add a Sight");

        // get zones
        ZoneDao zoneDao = new ZoneDao();
        List<Zone> allZones = zoneDao.getAllZones();

        // place allZones into request
        request.setAttribute("allZones", allZones);

        // forward to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addSight.jsp");
        dispatcher.forward(request, response);
    }
}