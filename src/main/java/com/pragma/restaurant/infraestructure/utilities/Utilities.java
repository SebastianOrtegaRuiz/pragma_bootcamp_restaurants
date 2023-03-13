package com.pragma.restaurant.infraestructure.utilities;

public class Utilities implements IUtilities{
    @Override
    public boolean isNumeric(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validPhoneNumber(String string) {
        if(string.length() <= 13) {
            if (string.charAt(0) == '+') {
                return isNumeric(string.substring(1, string.length()));
            } else if (string.charAt(0) != '+') {
                return isNumeric(string);
            }
        }
        return false;
    }
}
