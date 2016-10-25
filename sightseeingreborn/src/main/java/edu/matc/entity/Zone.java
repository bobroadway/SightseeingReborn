package edu.matc.entity;

import javax.persistence.*;

/**
 * Created by Bo on 10/2/2016.
 */
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    //@GeneratedValue(generator = "increment")
    //@GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "zone_id")
    private Integer zoneId;

    @Column(name = "expansion")
    private String expansion;

    @Column(name = "region")
    private String region;

    @Column(name = "name")
    private String name;

    /**
     * Instantiates a new User.
     */
    public Zone() {
    }

    /**
     * Instantiates a new User.
     *
     * @param zoneId     the zone id
     * @param expansion  expansion the zone is part of
     * @param region     region the zone is in
     * @param name       the name of the zone
     */
    public Zone(Integer zoneId, String expansion, String region, String name) {
        this.zoneId = zoneId;
        this.expansion = expansion;
        this.region = region;
        this.name = name;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

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
