package edu.matc.service;

import edu.matc.persistence.SightDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Service to delete a sight from the SIGHT table.
 * Created on 11/24/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "DeleteSight",
        urlPatterns = { "/deleteSight"}
)
public class DeleteSight extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The doGet method for DeleteSight. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In DeleteSight doGet method.");

        // instantiate dao
        SightDao dao = new SightDao();

        // delete the sight
        log.info("Sight to delete: " + dao.getSight(Integer.parseInt(request.getParameter("sightId"))).getName());
        dao.deleteSight(Integer.parseInt(request.getParameter("sightId")));

        // redirect to referer as a sight can be deleted from /admin or /index
        log.info("Redirecting to: " + request.getHeader("referer"));
        response.sendRedirect(request.getHeader("referer"));
    }

}