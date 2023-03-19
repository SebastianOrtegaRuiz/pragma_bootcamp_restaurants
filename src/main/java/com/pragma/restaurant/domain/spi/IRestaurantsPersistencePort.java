package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.springframework.data.domain.Page;

public interface IRestaurantsPersistencePort {
    RestaurantsModel saveRestaurants(RestaurantsModel restaurantsModel);

    Page<RestaurantsModel> getAllRestaurants(int pages, int records);

    RestaurantsModel getRestaurantById(Long id);
}
