package com.pragma.restaurant.application.dto.request.orders;

import com.pragma.restaurant.application.dto.request.Dishes_OrdersRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrdersRequestDto {
    private Long id_client;
    private Date date;
    private String status;
    private Long id_chef;
    private Long id_restaurant;
    private List<Dishes_OrdersRequestDto> dishes_OrdersRequestDto;
}
