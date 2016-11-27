package edu.matc.entity;

import edu.matc.util.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="zone_id")
    private Zone zone;

    /**
     * Instantiates a new User.
     */
    public Sight() {
    }

    /**
     * Instantiates a new User.
     *
     * @param zone        the zone of the sight
     * @param name        name of the sight
     * @param cordX       x coordinates of the sight
     * @param cordY       y coordinates of the sight
     * @param userName    userName for sight uploader
     */
    public Sight(Zone zone, String name, Integer cordX, Integer cordY, String userName) {
        this.zone = zone;
        this.name = name;
        this.cordX = cordX;
        this.cordY = cordY;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
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

    public LocalDateTime getCreated() { return created; }

    public Zone getZone() { return zone; }

    public void setId(Integer id) {
        this.id = id;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setZone(Zone zone) { this.zone = zone; }

    @Override
    public String toString() {
        return "Sight{" +
                "id=" + id +
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

//    public String formattedDate() {
//
//        return this.created.format(formatter);
//    }
}