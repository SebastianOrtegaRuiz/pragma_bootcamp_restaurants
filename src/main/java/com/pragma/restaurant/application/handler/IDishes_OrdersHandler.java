package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.Dishes_OrdersResponseDto;

import java.util.List;

public interface IDishes_OrdersHandler {
    void saveDishes_Orders(Dishes_OrdersRequestDto dishes_ordersRequestDto);

    List<Dishes_OrdersResponseDto> getAllDishes_Orders();

}
