package edu.matc.service;

import java.io.*;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.matc.entity.Sight;
import edu.matc.persistence.SightDao;
import edu.matc.persistence.ZoneDao;

/**
 * Service to Insert a Sight.
 * Created on 12/3/16
 * @author Bo Broadway
 */
@WebServlet(
        name = "InsertSight",
        urlPatterns = { "/insertSight" }
)
public class InsertSight extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The doPost method for InsertSight. Receives input from form and returns the response.
     * @param request request received
     * @param response response to send
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In InsertSight doPost method.");

        // instantiate daos
        SightDao sightDao     = new SightDao();
        ZoneDao zoneDao       = new ZoneDao();

        // required fields
        String name           = null;
        Integer zoneId        = null;
        Integer cordX         = null;
        Integer cordY         = null;

        // not required fields
        String description    = null;
        Integer cordZ         = null;
        String fileName       = null;
        boolean fileIsPresent = false;

        final String UPLOAD_DIRECTORY = "C:\\Users\\Bo\\Dropbox\\School\\MadJavaEnt\\EnterpriseRepos\\SightseeingReborn\\sightseeingreborn\\src\\main\\webapp\\uploads";

        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            for(FileItem item : multiparts){
                if (item.isFormField()){
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();

                    // switch statement for required fields
                    switch (fieldName) {
                        case "name": name = fieldValue;
                            log.info("Name: " + fieldValue);
                            break;
                        case "zone": zoneId = Integer.parseInt(fieldValue);
                            log.info("Zone: " + fieldValue);
                            break;
                        case "xCord": cordX = Integer.parseInt(fieldValue);
                            log.info("X: " + fieldValue);
                            break;
                        case "yCord": cordY = Integer.parseInt(fieldValue);
                            log.info("Y: " + fieldValue);
                            break;
                        default: break;
                    }
                    if (fieldName.equals("description") && !fieldValue.equals("")) {
                        description = fieldValue;
                    }
                    if (fieldName.equals("zCord") && !fieldValue.equals("")) {
                        cordZ = Integer.parseInt(fieldValue);
                    }
                } else {
                    fileIsPresent = true;

                    // concatenate epoch time to front of original name for uniqueness;
                    fileName = Long.toString(System.currentTimeMillis()) + "_" + new File(item.getName()).getName();
                    log.info("File Name: " + fileName);

                    item.write( new File(UPLOAD_DIRECTORY + File.separator + fileName));
                    log.info("File: " + fileName + " uploaded.");
                }
            }

            // instantiate sight with required field variables
            Sight sight = new Sight(zoneDao.getZone(zoneId), name, cordX, cordY, request.getUserPrincipal().getName());

            // assign optional description
            if (description != null) {
                log.info("Description is present: " + description);
                sight.setDescription(description);
            }

            // assign optional zCord
            if (cordZ != null) {
                log.info("Z Cord is present: " + cordZ);
                sight.setCordZ(cordZ);
            }

            // assign ssUrl if there was a file uploaded
            if (fileIsPresent) {
                log.info("File is present: " + fileName);
                sight.setSsUrl(fileName);
            }

            log.info("Sight: " + sight);

            // add sight to database
            sightDao.addSight(sight);
            log.info("Sight: " + sight.getName() + " successfully created.");

            // redirect
            response.sendRedirect("/home");
        } catch (Exception e) {
            log.error(e);
        }



    }
}