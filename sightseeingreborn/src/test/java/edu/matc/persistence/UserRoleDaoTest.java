package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * UserRoleDaoTest
 * Created on 12/3/16
 * @author Bo Broadway
 */
public class UserRoleDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    UserRoleDao dao;
    UserRole userRole;
    UserRole userToDelete;

    @Before
    public void setup() {
        dao = new UserRoleDao();
        userRole = new UserRole("user");
    }

    @Test
    public void getUser() throws Exception {
        String userName = dao.addUserRole(userRole);
        userRole = dao.getUserRole("user");
        assertEquals("user", userRole.getUserName());
        dao.deleteUserRole(userName);
    }

    @Test
    public void addUserRole() throws Exception {
        assertEquals("user", dao.addUserRole(userRole));
    }

    @Test
    public void deleteUser() {
        userToDelete = new UserRole("delete");

        String newUserName = dao.addUserRole(userToDelete);
        assertNotNull(newUserName);

        dao.deleteUserRole(newUserName);
        assertEquals(null, dao.getUserRole(newUserName));
    }

    @After
    public void cleanUp() {
        dao.deleteUserRole(userRole.getUserName());
    }
}
