package com.pragma.restaurant.domain.spi;

import com.pragma.restaurant.application.dto.response.OrdersResponseDto;
import com.pragma.restaurant.domain.model.OrdersModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrdersPersistencePort {
    OrdersModel saveOrders(OrdersModel ordersModel);

    OrdersModel updateOrders(OrdersModel ordersModel);

    Page<OrdersModel> getAllOrders(int pages, int records, String status);

    List<OrdersModel> getOrdersByClientAndStatus(Long id);

    OrdersModel getOrdersById(Long id);
}
