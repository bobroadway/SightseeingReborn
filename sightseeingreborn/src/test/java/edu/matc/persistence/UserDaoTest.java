package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * UserDaoTest
 * Created on 10/29/2016
 * @author Bo Broadway
 */
public class UserDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    UserDao dao;
    User user;
    User userToDelete;

    @Before
    public void setup() {
        dao = new UserDao();
        user = new User("user", "user");
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        String userName = dao.addUser(user);
        user = dao.getUser("user");
        assertEquals("user", user.getPassword());
        dao.deleteUser(userName);
    }

    @Test
    public void addUser() throws Exception {
        assertEquals("user", dao.addUser(user));
    }

    @Test
    public void deleteUser() {
        userToDelete = new User("delete", "delete");

        String newUserName = dao.addUser(userToDelete);
        assertNotNull(newUserName);

        dao.deleteUser(newUserName);
        assertEquals(null, dao.getUser(newUserName));
    }

    @Test
    public void updateUser() throws Exception {
        String userName = dao.addUser(user);
        User userToUpdate = dao.getUser(userName);
        String originalPassword = userToUpdate.getPassword();
        assertNotEquals("pass", originalPassword);
        userToUpdate.setPassword("pass");
        dao.updateUser(userToUpdate);
        assertEquals("pass", dao.getUser(userName).getPassword());

        userToUpdate.setPassword(originalPassword);
        dao.updateUser(userToUpdate);
        assertEquals("user", dao.getUser(userName).getPassword());
    }

    @After
    public void cleanUp() {
        if (dao.getUser(user.getUserName()) != null) {
            dao.deleteUser(user.getUserName());
        }
    }

}
