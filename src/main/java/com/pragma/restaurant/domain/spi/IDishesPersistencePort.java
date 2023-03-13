package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.DishesModel;

import java.util.List;

public interface IDishesPersistencePort {
    DishesModel saveDishes(DishesModel dishesModel);

    List<DishesModel> getAllDishes();
}
