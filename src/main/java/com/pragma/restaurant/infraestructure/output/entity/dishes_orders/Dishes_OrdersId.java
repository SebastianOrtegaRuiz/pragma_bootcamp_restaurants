package com.pragma.restaurant.infraestructure.output.entity.dishes_orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dishes_OrdersId implements Serializable {
    private Long id_order;
    private Long id_dish;
}
