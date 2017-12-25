package com.hypertrack.beans;

import com.hypertrack.constants.ErrorCode;

/**
 * @author abhinav
 * @date 25/12/17
 */

public class PolylineOutput extends ApiOutput {
    private String polylineData;
    public PolylineOutput(){}
    public PolylineOutput(ErrorCode errorCode){
        super(errorCode);
    }
    public String getPolylineData() {
        return polylineData;
    }

    public void setPolylineData(String polylineData) {
        this.polylineData = polylineData;
    }
}
