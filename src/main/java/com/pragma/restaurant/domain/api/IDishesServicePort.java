package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.DishesModel;

import java.util.List;

public interface IDishesServicePort {
    void saveDishes(DishesModel dishesModel);

    List<DishesModel> getAllDishes();
}
