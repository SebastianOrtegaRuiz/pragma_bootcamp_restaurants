package com.pragma.restaurant.domain.model;

import java.util.Date;

public class OrdersModel {
    private Long id;
    private Long id_client;
    private Date date;
    private String status;
    private Long id_chef;
    private Long id_restaurant;

    public OrdersModel(Long id, Long id_client, Date date, String status, Long id_chef, Long id_restaurant) {
        this.id = id;
        this.id_client = id_client;
        this.date = date;
        this.status = status;
        this.id_chef = id_chef;
        this.id_restaurant = id_restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId_chef() {
        return id_chef;
    }

    public void setId_chef(Long id_chef) {
        this.id_chef = id_chef;
    }

    public Long getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Long id_restaurant) {
        this.id_restaurant = id_restaurant;
    }
}
