package com.example.Fioo;

public enum MessageRequest {
    SUCCESS("Success"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    INVALID_PATH_PARAMETER("Invalid Path Parameter"),
    DATA_NOT_FOUND("Data Not Found"),
    BAD_REQUEST("Bad Request :/");

    private String message;

    MessageRequest(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
