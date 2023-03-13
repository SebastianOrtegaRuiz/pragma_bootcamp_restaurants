package com.pragma.restaurant.domain.model;

public class Dishes_OrdersModel {

    private Long id_order;
    private Long id_dish;
    private int units;

    public Dishes_OrdersModel(Long id_order, Long id_dish, int units) {
        this.id_order = id_order;
        this.id_dish = id_dish;
        this.units = units;
    }

    public Long getId_order() {
        return id_order;
    }

    public Long getId_dish() {
        return id_dish;
    }

    public int getUnits() {
        return units;
    }
}
