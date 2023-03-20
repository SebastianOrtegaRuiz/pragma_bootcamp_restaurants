package com.pragma.restaurant.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrdersUpdateRequestDto {
    private Long id;
    private Long id_client;
    private Date date;
    private String status;
    private Long id_chef;
    private Long id_restaurant;
}