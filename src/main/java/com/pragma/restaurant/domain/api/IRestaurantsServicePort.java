package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRestaurantsServicePort {
    void saveRestaurants(RestaurantsModel restaurantsModel);

    Page<RestaurantsModel> getAllRestaurants(int pages, int records);
}
