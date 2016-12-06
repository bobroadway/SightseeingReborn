package edu.matc.controller;

import edu.matc.persistence.SightDao;
import edu.matc.util.Utilities;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Sight Image Controller. This servlet serves up an image from the uploads directory, taking the sightId of the image
 * as "parameter" from the path.
 * Created on 12/4/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "SightImage",
        urlPatterns = { "/sightImage/*" }
)
public class SightImageController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties = Utilities.loadProperties("ssr.properties");

    /**
     * The doGet method for SightImageController. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In Sight Image doGet method.");

        final String UPLOAD_DIRECTORY = properties.getProperty("uploadDirectory");
        SightDao dao = new SightDao();

        // get sightId from the url
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        Integer sightId = Integer.parseInt(pathParts[1]);

        // get file name from sight table
        String sightImageName = dao.getSight(sightId).getSsUrl();

        // create path
        Path sightImagePath = Paths.get(UPLOAD_DIRECTORY, sightImageName);

        // set content type
        response.setContentType(Files.probeContentType(sightImagePath));

        // write image path to outputstream
        Files.copy(sightImagePath, response.getOutputStream());
        log.info("Sight Image Name: " + sightImageName);

    }

}
