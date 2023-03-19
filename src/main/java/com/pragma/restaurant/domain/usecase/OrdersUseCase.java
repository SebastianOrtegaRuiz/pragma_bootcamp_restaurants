package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.api.IOrdersServicePort;
import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.domain.spi.IOrdersPersistencePort;

import java.util.Date;
import java.util.List;

public class OrdersUseCase implements IOrdersServicePort {

    private final IOrdersPersistencePort ordersPersistencePort;

    public OrdersUseCase(IOrdersPersistencePort ordersPersistencePort) {
        this.ordersPersistencePort = ordersPersistencePort;
    }

    @Override
    public OrdersModel saveOrders(OrdersModel ordersModel) {
        ordersModel.setDate(new Date());
        ordersModel.setStatus("pendiente");
        return ordersPersistencePort.saveOrders(ordersModel);
    }

    @Override
    public List<OrdersModel> getAllOrders() {
        return ordersPersistencePort.getAllOrders();
    }

    @Override
    public List<OrdersModel> getOrdersByClientAndStatus(Long id) {
        return ordersPersistencePort.getOrdersByClientAndStatus(id);
    }
}
