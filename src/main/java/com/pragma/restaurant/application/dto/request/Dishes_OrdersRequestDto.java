package com.pragma.restaurant.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dishes_OrdersRequestDto {
    private Long id_order;
    private Long id_dish;
    private int units;
}
