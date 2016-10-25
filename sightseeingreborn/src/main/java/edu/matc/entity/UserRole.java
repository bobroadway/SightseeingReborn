package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Bo on 10/24/2016.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "role_name")
    private String roleName;

    /**
     * Instantiates a new User.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName  the user_name, primary key
     * @param roleName  the role name
     */
    public UserRole(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
