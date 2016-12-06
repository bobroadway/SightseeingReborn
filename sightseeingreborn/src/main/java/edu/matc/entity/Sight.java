package edu.matc.entity;

import edu.matc.util.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * This is the Sight class for Sightseeing Reborn. This is the class that interfaces with the SIGHT table.
 * Created on 10/2/16
 * @author Bo Broadway
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
     * No Argument Constructor for Sight.
     */
    public Sight() {
    }

    /**
     * Constructor Sight that takes all required fields / not nullable attributes.
     * @param zone        the Zone of the sight
     * @param name        name of the sight
     * @param cordX       x coordinates of the sight
     * @param cordY       y coordinates of the sight
     * @param userName    userName for sight uploader
     */
    public Sight(Zone zone, String name, Integer cordX, Integer cordY, String userName) {
        this();
        this.zone = zone;
        this.name = name;
        this.cordX = cordX;
        this.cordY = cordY;
        this.userName = userName;
    }

    /**
     * Getter for sight id.
     * @return id of the sight
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter for sight name.
     * @return name of the sight
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for sight description.
     * @return description of the sight
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for sight cordX.
     * @return cordX of the sight
     */
    public Integer getCordX() {
        return cordX;
    }

    /**
     * Getter for sight cordY.
     * @return cordY of the sight
     */
    public Integer getCordY() {
        return cordY;
    }

    /**
     * Getter for sight cordZ.
     * @return cordZ of the sight
     */
    public Integer getCordZ() {
        return cordZ;
    }

    /**
     * Getter for sight ssUrl.
     * @return ssUrl of the sight
     */
    public String getSsUrl() {
        return ssUrl;
    }

    /**
     * Getter for sight userName.
     * @return userName of the sight
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Getter for sight created (timestamp).
     * @return created of the sight
     */
    public LocalDateTime getCreated() { return created; }

    /**
     * Getter for sight Zone.
     * @return Zone of the sight
     */
    public Zone getZone() { return zone; }

    /**
     * Setter of the sight id
     * @param id sight id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Setter of the sight name
     * @param name sight name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter of the sight description
     * @param description sight description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter of the sight cordX
     * @param cordX sight cordX
     */
    public void setCordX(Integer cordX) {
        this.cordX = cordX;
    }

    /**
     * Setter of the sight cordY
     * @param cordY sight cordY
     */
    public void setCordY(Integer cordY) {
        this.cordY = cordY;
    }

    /**
     * Setter of the sight cordZ
     * @param cordZ sight cordZ
     */
    public void setCordZ(Integer cordZ) {
        this.cordZ = cordZ;
    }

    /**
     * Setter of the sight ssUrl
     * @param ssUrl sight ssUrl
     */
    public void setSsUrl(String ssUrl) {
        this.ssUrl = ssUrl;
    }

    /**
     * Setter of the sight userName
     * @param userName sight userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Setter of the sight created
     * @param created sight created
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Setter of the sight zone
     * @param zone sight zone
     */
    public void setZone(Zone zone) { this.zone = zone; }

    /**
     * Sight toString() method.
     * @return information about the sight
     */
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

}