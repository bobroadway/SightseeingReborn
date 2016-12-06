package edu.matc.entity;

import javax.persistence.*;

/**
 * This is the Zone class for Sightseeing Reborn. This is the class that interfaces with the ZONE table.
 * Created on 10/2/16
 * @author Bo Broadway
 */
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "expansion")
    private String expansion;

    @Column(name = "region")
    private String region;

    @Column(name = "name")
    private String name;

    /**
     * No Argument Constructor for Zone.
     */
    public Zone() {
    }

    /**
     * Instantiates a new Zone.
     * @param zoneId     the zone id
     * @param expansion  expansion the zone is part of
     * @param region     region the zone is in
     * @param name       the name of the zone
     */
    public Zone(Integer zoneId, String expansion, String region, String name) {
        this();
        this.zoneId = zoneId;
        this.expansion = expansion;
        this.region = region;
        this.name = name;
    }

    /**
     * Getter for zone id.
     * @return id of the zone
     */
    public Integer getZoneId() {
        return zoneId;
    }

    /**
     * Getter for zone expansion.
     * @return expansion of the zone
     */
    public String getExpansion() {
        return expansion;
    }

    /**
     * Getter for zone region.
     * @return region of the zone
     */
    public String getRegion() {
        return region;
    }

    /**
     * Getter for zone name.
     * @return name of the zone
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of the zone id
     * @param zoneId zone id
     */
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * Setter of the zone expansion
     * @param expansion zone expansion
     */
    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    /**
     * Setter of the zone region
     * @param region zone region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Setter of the zone name
     * @param name zone name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Zone toString() method.
     * @return information about the zone
     */
    @Override
    public String toString() {
        return "Zone{" +
                "zoneId=" + zoneId +
                ", expansion='" + expansion + '\'' +
                ", region='" + region + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
