package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.DishesModel;

import java.util.List;

public interface IDishesPersistencePort {
    DishesModel saveDishes(DishesModel dishesModel);

    DishesModel updateDishes(DishesModel dishesModel);

    DishesModel changeStatusDishes(DishesModel dishesModel);

    List<DishesModel> getAllDishes();

    DishesModel getDishesById(Long id);
}
