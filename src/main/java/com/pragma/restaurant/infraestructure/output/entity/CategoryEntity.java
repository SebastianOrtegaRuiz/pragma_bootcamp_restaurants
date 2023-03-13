package com.pragma.restaurant.infraestructure.output.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Column(length = 45, nullable = false)
    private String name;

    @NotNull
    @NotEmpty(message = "Description cannot be empty")
    @Column(length = 150, nullable = false)
    private String description;

}
