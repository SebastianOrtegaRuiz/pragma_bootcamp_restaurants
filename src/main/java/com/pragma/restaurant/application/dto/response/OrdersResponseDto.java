package com.pragma.restaurant.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrdersResponseDto {
    private Long id;
    private Long id_client;
    private Date date;
    private String status;
    private Long id_chef;
    private Long id_restaurant;
}
