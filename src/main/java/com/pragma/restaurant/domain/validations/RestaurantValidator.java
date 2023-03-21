package com.pragma.restaurant.domain.validations;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantValidator {


    public boolean isNumeric(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

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
