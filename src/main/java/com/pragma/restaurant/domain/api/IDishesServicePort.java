package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.DishesModel;

import java.util.List;

public interface IDishesServicePort {
    void saveDishes(DishesModel dishesModel);

    void updateDishes(DishesModel dishesModel);

    void changeStatusDishes(DishesModel dishesModel);

    List<DishesModel> getAllDishes();

    DishesModel getDishesById(Long id);
}
