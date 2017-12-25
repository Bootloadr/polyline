package com.hypertrack.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author abhinav
 * @date 24/12/17
 */

@Entity
@Table(name ="encoded_polyline",indexes = { @Index(name = "my_index", columnList = "trip_id") })
public class EncodedData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "trip_id", unique = true)
    private String tripId;
    @Column(name = "encoded_loc")
    private String encodedLoc;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "last_updated")
    private Date lastUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getEncodedLoc() {
        return encodedLoc;
    }

    public void setEncodedLoc(String encodedLoc) {
        this.encodedLoc = encodedLoc;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}