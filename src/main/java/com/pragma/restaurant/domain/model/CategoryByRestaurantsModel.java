package com.pragma.restaurant.domain.model;

import java.util.List;

public class CategoryByRestaurantsModel {
    private String name;
    private String description;
    private String dischesname;

    public CategoryByRestaurantsModel(String name, String description, String dischesname) {
        this.name = name;
        this.description = description;
        this.dischesname = dischesname;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDischesname() {
        return dischesname;
    }

}
