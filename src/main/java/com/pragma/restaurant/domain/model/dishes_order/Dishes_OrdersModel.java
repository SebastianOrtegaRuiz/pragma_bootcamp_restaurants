package com.pragma.restaurant.domain.model.dishes_order;

public class Dishes_OrdersModel {

    private Dishes_OrdersIdModel id;
    private int units;

    public Dishes_OrdersModel(Dishes_OrdersIdModel id, int units) {
        this.id = id;
        this.units = units;
    }

    public Dishes_OrdersIdModel getId() {
        return id;
    }

    public void setId(Dishes_OrdersIdModel id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }
}
