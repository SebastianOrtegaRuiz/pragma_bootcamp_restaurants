package com.pragma.restaurant.infraestructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition",
            "Phone number is not valid",
            "Name cannot be only numbers");

    private final String message;
    private final String validNumber;
    private final String validName;


    ExceptionResponse(String message, String validMessage, String validName) {
        this.message = message;
        this.validNumber = validMessage;
        this.validName = validName;
    }

    public String getMessage() {
        return this.message;
    }

    public String getValidNumber() {
        return this.validNumber;
    }

    public String getValidName() {
        return this.validName;
    }
}
