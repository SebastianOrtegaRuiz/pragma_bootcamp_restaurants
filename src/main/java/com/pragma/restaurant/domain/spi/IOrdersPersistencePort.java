package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.domain.model.OrdersModel;

import java.util.List;

public interface IOrdersPersistencePort {
    OrdersModel saveOrders(OrdersModel ordersModel);

    List<OrdersModel> getAllOrders();
}
