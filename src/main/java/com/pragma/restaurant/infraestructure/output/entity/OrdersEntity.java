package com.pragma.restaurant.infraestructure.output.entity;

import com.pragma.restaurant.infraestructure.output.entity.dishes_orders.Dishes_OrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_client;


    @Column(nullable = false)
    private Date date;

    @NotNull
    @NotEmpty(message = "Status cannot be empty")
    @Column(length = 14, nullable = false)
    private String status;

    private Long id_chef;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_restaurant;

}
