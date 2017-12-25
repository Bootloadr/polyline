package com.hypertrack.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author abhinav
 * @date 24/12/17
 */

public class ApiInput{
    private List<LocationInput> data;
    private String tripId;

    public List<LocationInput> getData() {
        return data;
    }

    public void setData(List<LocationInput> data) {
        this.data = data;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
