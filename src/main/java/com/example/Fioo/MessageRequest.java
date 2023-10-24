package com.example.Fioo;

public enum MessageRequest {
    SUCCESS("Success"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    DATA_NOT_FOUND("Data Not Found"),
    BAD_REQUEST("Bad Request :/"),
    SUCCESS_NULL("Success but data was not found");

    private String message;

    MessageRequest(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
