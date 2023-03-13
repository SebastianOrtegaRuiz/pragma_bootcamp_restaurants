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
        dishesPersistencePort.saveDishes(dishesModel);
    }

    /*@Override
    public void updateDishes(DishesModel dishesModel) {
        if(dishesModel.getActive() == null)
        dishesPersistencePort.updateDishes(dishesModel);
        dishesPersistencePort.saveDishes(dishesModel);
    }*/

    @Override
    public List<DishesModel> getAllDishes() {
        return dishesPersistencePort.getAllDishes();
    }
}
