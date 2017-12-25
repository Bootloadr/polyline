package com.hypertrack.beans;

import com.hypertrack.constants.ErrorCode;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author abhinav
 * @date 24/12/17
 */

public class ApiOutput{
    private boolean success = true;
    private String errorCode;
    private String errorMessage;

    public ApiOutput(){}

    public ApiOutput(ErrorCode code){
        success = false;
        errorCode = code.getCode();
        errorMessage = code.getDescription();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
