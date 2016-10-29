package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Bo on 10/2/2016.
 */
@Entity
@Table(name = "sight")
public class Sight {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cord_x")
    private Integer cordX;

    @Column(name = "cord_y")
    private Integer cordY;

    @Column(name = "cord_z")
    private Integer cordZ;

    @Column(name = "ss_url")
    private String ssUrl;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "created")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate created;

    /**
     * Instantiates a new User.
     */
    public Sight() {
    }

    /**
     * Instantiates a new User.
     *
     * @param zoneId      the id of the sight zone
     * @param name        name of the sight
     * @param description description of the sight
     * @param cordX       x coordinates of the sight
     * @param cordY       y coordinates of the sight
     * @param cordZ       z coordinates of the sight
     * @param ssUrl       url for optional screenshot
     * @param userName    userName for sight uploader
     * @param created     creation timestamp
     */
    public Sight(Integer zoneId, String name, Integer cordX, Integer cordY, String userName) {
        this.zoneId = zoneId;
        this.name = name;
        this.cordX = cordX;
        this.cordY = cordY;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCordX() {
        return cordX;
    }

    public Integer getCordY() {
        return cordY;
    }

    public Integer getCordZ() {
        return cordZ;
    }

    public String getSsUrl() {
        return ssUrl;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCordX(Integer cordX) {
        this.cordX = cordX;
    }

    public void setCordY(Integer cordY) {
        this.cordY = cordY;
    }

    public void setCordZ(Integer cordZ) {
        this.cordZ = cordZ;
    }

    public void setSsUrl(String ssUrl) {
        this.ssUrl = ssUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "id=" + id +
                ", zoneId=" + zoneId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cordX=" + cordX +
                ", cordY=" + cordY +
                ", cordZ=" + cordZ +
                ", ssUrl='" + ssUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", created=" + created +
                '}';
    }
}