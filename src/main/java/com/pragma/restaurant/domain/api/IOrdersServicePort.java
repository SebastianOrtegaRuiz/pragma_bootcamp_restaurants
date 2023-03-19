package com.pragma.restaurant.domain.api;

import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;

import java.util.List;

public interface IOrdersServicePort {
    OrdersModel saveOrders(OrdersModel ordersModel);

    List<OrdersModel> getAllOrders();

    List<OrdersModel> getOrdersByClientAndStatus(Long id);
}
