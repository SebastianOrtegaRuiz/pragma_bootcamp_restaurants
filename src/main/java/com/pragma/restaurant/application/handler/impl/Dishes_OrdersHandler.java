package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import com.pragma.restaurant.application.dto.response.Dishes_OrdersResponseDto;
import com.pragma.restaurant.application.handler.IDishes_OrdersHandler;
import com.pragma.restaurant.application.mapper.dishesorders.IDishes_OrdersRequestMapper;
import com.pragma.restaurant.application.mapper.dishesorders.IDishes_OrdersResponseMapper;
import com.pragma.restaurant.domain.api.IDishes_OrdersServicePort;
import com.pragma.restaurant.domain.model.Dishes_OrdersModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Dishes_OrdersHandler implements IDishes_OrdersHandler {
    private final IDishes_OrdersServicePort dishes_ordersServicePort;
    private final IDishes_OrdersRequestMapper dishes_ordersRequestMapper;
    private final IDishes_OrdersResponseMapper dishes_ordersResponseMapper;
    @Override
    public void saveDishes_Orders(Dishes_OrdersRequestDto dishes_ordersRequestDto) {
        Dishes_OrdersModel dishes_ordersModel = dishes_ordersRequestMapper.toDishes_Orders(dishes_ordersRequestDto);
        dishes_ordersServicePort.saveDishes_Orders(dishes_ordersModel);
    }

    @Override
    public List<Dishes_OrdersResponseDto> getAllDishes_Orders() {
        return dishes_ordersResponseMapper.toResponseList(dishes_ordersServicePort.getAllDishes_Orders());
    }
}
