package com.hypertrack.constants;

/**
 * @author abhinav
 * @date 24/12/17
 */

public enum ErrorCode {
    INVALID_DATA("HPTK_000001","Data is invalid"),
    JAVA_EXCEPTION("HPTK_000002","Exception caught"),
    LOCATION_DATA_EMPTY("HPTK_000003","Location data is empty, Please send location data"),
    DATA_NOT_FOUND_FOR_TRIP("HPTK_000004","Data not found for this trip");
    private String code;
    private String description;

    private ErrorCode(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
