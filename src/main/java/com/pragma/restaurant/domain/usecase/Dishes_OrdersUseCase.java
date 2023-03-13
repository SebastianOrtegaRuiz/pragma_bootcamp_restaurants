package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.IDishes_OrdersServicePort;
import com.pragma.restaurant.domain.model.Dishes_OrdersModel;
import com.pragma.restaurant.domain.spi.IDishes_OrdersPersistencePort;

import java.util.List;

public class Dishes_OrdersUseCase implements IDishes_OrdersServicePort {

    private final IDishes_OrdersPersistencePort dishes_ordersPersistencePort;

    public Dishes_OrdersUseCase(IDishes_OrdersPersistencePort dishes_ordersPersistencePort) {
        this.dishes_ordersPersistencePort = dishes_ordersPersistencePort;
    }

    @Override
    public void saveDishes_Orders(Dishes_OrdersModel dishes_ordersModel) {
        dishes_ordersPersistencePort.saveDishes_Orders(dishes_ordersModel);
    }

    @Override
    public List<Dishes_OrdersModel> getAllDishes_Orders() {
        return dishes_ordersPersistencePort.getAllDishes_Orders();
    }
}
