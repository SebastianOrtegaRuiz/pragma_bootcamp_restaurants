package com.pragma.restaurant.infraestructure.utilities;

public interface IUtilities {
    boolean isNumeric(String string);
    boolean validPhoneNumber(String string);
    String getRol(String token);

    String getEmail(String token);
}