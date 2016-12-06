package edu.matc.entity;

import javax.persistence.*;

/**
 * This is the UserRole class for Sightseeing Reborn. This is the class that interfaces with the USER_ROLE table.
 * Created on 10/2/16
 * @author Bo Broadway
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
     * No Argument Constructor for UserRole.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new UserRole
     * @param userName  the user_name, primary key
     * @param roleName  the role_name
     */
    public UserRole(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    /**
     * Instantiates a new User with role of registeredUser.
     * @param userName  the user_name, primary key
     */
    public UserRole(String userName) {
        this.userName = userName;
        this.roleName = "registeredUser";
    }

    /**
     * Getter for userrole userName.
     * @return userName of the userrole
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Getter for userrole roleName.
     * @return roleName of the userrole
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Setter of the userrole userName
     * @param userName userrole userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter of the userrole roleName
     * @param roleName userrole roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * UserRole toString() method.
     * @return information about the userrole
     */
    @Override
    public String toString() {
        return "UserRole{" +
                "userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
