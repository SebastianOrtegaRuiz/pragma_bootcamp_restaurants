package com.pragma.restaurant.infraestructure.output.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Column(length = 45, nullable = false)
    private String name;

    @NotNull
    @NotEmpty(message = "Address cannot be empty")
    @Column(length = 45, nullable = false)
    private String address;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_owner;

    @NotNull
    @NotEmpty(message = "Phone number cannot be empty")
    @Column(length = 13, nullable = false)
    private String phone;

    @NotNull
    @NotEmpty(message = "Logo cannot be empty")
    @Column(length = 200, nullable = false)
    private String url_logo;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long nit;
}
