package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.domain.model.OrdersModel;

import java.util.List;

public interface IOrdersServicePort {
    void saveOrders(OrdersModel ordersModel);

    List<OrdersModel> getAllOrders();
}
