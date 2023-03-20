package com.pragma.restaurant.infraestructure.output.entity.dishes_orders;

import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "dishes_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dishes_OrdersEntity implements Serializable {

    @EmbeddedId
    @NotNull
    private Dishes_OrdersId id;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private int units;

}
