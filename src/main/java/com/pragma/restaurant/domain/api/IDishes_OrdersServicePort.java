package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.Dishes_OrdersModel;

import java.util.List;

public interface IDishes_OrdersServicePort {
    void saveDishes_Orders(Dishes_OrdersModel dishes_ordersModel);

    List<Dishes_OrdersModel> getAllDishes_Orders();
}
