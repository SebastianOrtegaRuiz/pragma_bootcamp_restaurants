package com.pragma.restaurant.domain.model.dishes_order;

public class Dishes_OrdersIdModel {

    private Long id_order;
    private Long id_dish;

    public Dishes_OrdersIdModel(Long id_order, Long id_dish) {
        this.id_order = id_order;
        this.id_dish = id_dish;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public void setId_dish(Long id_dish) {
        this.id_dish = id_dish;
    }

    public Long getId_order() {
        return id_order;
    }

    public Long getId_dish() {
        return id_dish;
    }

}
