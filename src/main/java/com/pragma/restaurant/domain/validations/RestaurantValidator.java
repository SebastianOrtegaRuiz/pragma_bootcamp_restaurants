package com.pragma.restaurant.domain.validations;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantValidator {

    public void validate(RestaurantsModel restaurantsModel) {
        if(restaurantsModel.getName() == "") {
            throw new NoDataFoundException();
        }
    }
}
