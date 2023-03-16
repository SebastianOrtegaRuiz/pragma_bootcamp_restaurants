package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.IDishesServicePort;
import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.domain.spi.IDishesPersistencePort;

import java.util.List;

public class DishesUseCase implements IDishesServicePort {

    private final IDishesPersistencePort dishesPersistencePort;

    public DishesUseCase(IDishesPersistencePort dishesPersistencePort) {
        this.dishesPersistencePort = dishesPersistencePort;
    }

    @Override
    public void saveDishes(DishesModel dishesModel) {
        dishesModel.setActive(true);
        dishesPersistencePort.saveDishes(dishesModel);
    }

    @Override
    public void updateDishes(DishesModel dishesModel) {
        dishesPersistencePort.updateDishes(dishesModel);
    }

    @Override
    public void changeStatusDishes(DishesModel dishesModel) {
        dishesPersistencePort.changeStatusDishes(dishesModel);
    }

    @Override
    public List<DishesModel> getAllDishes() {
        return dishesPersistencePort.getAllDishes();
    }

    @Override
    public DishesModel getDishesById(Long id) {
        return dishesPersistencePort.getDishesById(id);
    }
}
