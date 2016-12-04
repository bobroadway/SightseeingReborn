package edu.matc.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import edu.matc.entity.Sight;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.SightDao;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
import edu.matc.persistence.ZoneDao;
import org.apache.log4j.Logger;

/**
 * Home page controller.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "InsertSight",
        urlPatterns = { "/insertSight" }
)
public class InsertSight extends HttpServlet {
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
        log.info("In InsertSight doPost method.");

        // logging
        log.info("Name: " + request.getParameter("name"));
        log.info("Desc: " + request.getParameter("description"));
        log.info("Zone: " + request.getParameter("zone"));
        log.info("X: " + request.getParameter("xCord"));
        log.info("Y: " + request.getParameter("yCord"));
        log.info("Z: " + request.getParameter("zCord"));

        // instantiate daos
        SightDao sightDao = new SightDao();
        ZoneDao zoneDao = new ZoneDao();

        // required fields
        String name = request.getParameter("name");
        Integer zoneId = Integer.parseInt(request.getParameter("zone"));
        Integer cordX = Integer.parseInt(request.getParameter("xCord"));
        Integer cordY = Integer.parseInt(request.getParameter("yCord"));

        // not required fields
        String description;
        Integer cordZ;

        // instantiate sight with required field variables
        Sight sight = new Sight(zoneDao.getZone(zoneId), name, cordX, cordY, request.getUserPrincipal().getName());
        log.info("Sight: " + sight);

        // assign optional description
        if (request.getParameter("description") != "") {
            description = request.getParameter("description");
            log.info("Description is present: " + description);
            sight.setDescription(description);
        }

        // assign optional zCord
        if (request.getParameter("zCord") != "") {
            cordZ = Integer.parseInt(request.getParameter("zCord"));
            log.info("Z Cord is present: " + cordZ);
            sight.setCordZ(cordZ);
        }

        // add sight to database
        sightDao.addSight(sight);
        log.info("Sight: " + sight.getName() + " created.");

        // redirect
        response.sendRedirect("/home");

    }
}