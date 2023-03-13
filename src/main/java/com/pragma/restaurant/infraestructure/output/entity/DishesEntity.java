package com.pragma.restaurant.infraestructure.output.entity;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Column(length = 45, nullable = false)
    private String name;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_category;

    @NotNull
    @NotEmpty(message = "Description cannot be empty")
    @Column(length = 150, nullable = false)
    private String description;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private int price;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_restaurant;

    @NotNull
    @NotEmpty(message = "Logo cannot be empty")
    @Column(length = 200, nullable = false)
    private String url_image;

    @NotNull
    @BooleanFlag
    @Column(nullable = false)
    private Boolean active;
}
