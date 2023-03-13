package com.pragma.restaurant.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishesRequestDto {
    private String name;
    private Long id_category;
    private String description;
    private int price;
    private Long id_restaurant;
    private String url_image;
    private Boolean active;
    //private DishesOrdersEntity unit;
}
