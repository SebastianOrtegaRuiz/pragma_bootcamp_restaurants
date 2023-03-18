package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.springframework.data.domain.Page;

public interface IRestaurantsServicePort {
    void saveRestaurants(RestaurantsModel restaurantsModel);

    Page<RestaurantsModel> getAllRestaurants(int pages, int records);

    RestaurantsModel getRestaurantsById(Long id);
}
