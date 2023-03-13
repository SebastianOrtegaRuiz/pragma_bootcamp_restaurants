package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.api.IOrdersServicePort;
import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.domain.spi.IOrdersPersistencePort;

import java.util.List;

public class OrdersUseCase implements IOrdersServicePort {

    private final IOrdersPersistencePort ordersPersistencePort;

    public OrdersUseCase(IOrdersPersistencePort ordersPersistencePort) {
        this.ordersPersistencePort = ordersPersistencePort;
    }

    @Override
    public void saveOrders(OrdersModel ordersModel) {
        ordersPersistencePort.saveOrders(ordersModel);
    }

    @Override
    public List<OrdersModel> getAllOrders() {
        return ordersPersistencePort.getAllOrders();
    }
}
