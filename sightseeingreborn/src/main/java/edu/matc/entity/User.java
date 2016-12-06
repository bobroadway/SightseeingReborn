package edu.matc.entity;

import edu.matc.util.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * This is the User class for Sightseeing Reborn. This is the class that interfaces with the USER table.
 * Created on 10/2/16
 * @author Bo Broadway
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;

    @Column(name = "pic_url")
    private String picUrl;

    /**
     * No Argument Constructor for User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     * @param userName  the user_name, primary key
     * @param password   the password
     */
    public User(String userName, String password) {
        this();
        this.userName = userName;
        this.password = password;
    }

    /**
     * Getter for user userName.
     * @return userName of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Getter for user password.
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for user created (timestamp).
     * @return created (timestamp) of the user
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * Getter for user picUrl.
     * @return picUrl of the user
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * Setter of the user userName
     * @param userName user userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter of the user password
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter of the user created
     * @param created user created
     */
    public void setCreated(LocalDateTime created) { this.created = created; }

    /**
     * Setter of the user picUrl
     * @param picUrl user picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * User toString() method.
     * @return information about the user
     */
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
