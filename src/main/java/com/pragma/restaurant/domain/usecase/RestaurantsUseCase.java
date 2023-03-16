package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.IRestaurantsServicePort;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.domain.spi.IRestaurantsPersistencePort;
import com.pragma.restaurant.domain.validations.RestaurantValidator;
import org.springframework.data.domain.Page;

public class RestaurantsUseCase implements IRestaurantsServicePort {

    private final IRestaurantsPersistencePort restaurantsPersistencePort;
    private final RestaurantValidator restaurantValidator;

    public RestaurantsUseCase(IRestaurantsPersistencePort restaurantsPersistencePort, RestaurantValidator restaurantValidator) {
        this.restaurantsPersistencePort = restaurantsPersistencePort;
        this.restaurantValidator = restaurantValidator;
    }

    @Override
    public void saveRestaurants(RestaurantsModel restaurantsModel) {
        //restaurantValidator.validate(restaurantsModel);
        restaurantsPersistencePort.saveRestaurants(restaurantsModel);
    }

    @Override
    public Page<RestaurantsModel> getAllRestaurants(int pages, int records) {
        return restaurantsPersistencePort.getAllRestaurants(pages, records);
    }

    @Override
    public RestaurantsModel getRestaurantsById(Long id) {
        return restaurantsPersistencePort.getRestaurantById(id);
    }
}
