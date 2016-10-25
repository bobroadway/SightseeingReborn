package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Bo on 10/2/2016.
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
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate created;

    @Column(name = "pic_url")
    private String picUrl;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName  the user_name, primary key
     * @param password   the password
     * @param created    creation timestamp
     * @param picUrl    url to screenshot
     */
    public User(String userName, String password, LocalDate created, String picUrl) {
        this.userName = userName;
        this.password = password;
        this.created = created;
        this.picUrl = picUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreated() {
        return created;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

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
