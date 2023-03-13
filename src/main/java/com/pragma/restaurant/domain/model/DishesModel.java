package com.pragma.restaurant.domain.model;

public class DishesModel {
    private Long id;
    private String name;
    private Long id_category;
    private String description;
    private int price;
    private Long id_restaurant;
    private String url_image;
    private Boolean active;

    public DishesModel(Long id, String name, Long id_category, String description, int price, Long id_restaurant, String url_image, Boolean active) {
        this.id = id;
        this.name = name;
        this.id_category = id_category;
        this.description = description;
        this.price = price;
        this.id_restaurant = id_restaurant;
        this.url_image = url_image;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getId_category() {
        return id_category;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Long getId_restaurant() {
        return id_restaurant;
    }

    public String getUrl_image() {
        return url_image;
    }

    public Boolean getActive() {
        return active;
    }

}
