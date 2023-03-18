package com.pragma.restaurant.domain.model;

import java.util.List;

public class CategoryModel {

    private Long id;
    private String name;
    private String description;
    private List<DishesModel> dishesModel;

    public CategoryModel(Long id, String name, String description, List<DishesModel> dishesModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dishesModel = dishesModel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<DishesModel> getDishesModel() {
        return dishesModel;
    }

}
