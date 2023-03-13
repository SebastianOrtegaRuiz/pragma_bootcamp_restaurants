package com.pragma.restaurant.domain.model;

public class RestaurantsModel {
    private Long id;
    private String name;
    private String address;
    private Long id_owner;
    private String phone;
    private String url_logo;
    private Long nit;

    public RestaurantsModel(Long id, String name, String address, Long id_owner, String phone, String url_logo, Long nit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.id_owner = id_owner;
        this.phone = phone;
        this.url_logo = url_logo;
        this.nit = nit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getId_owner() {
        return id_owner;
    }

    public String getPhone() {
        return phone;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public Long getNit() {
        return nit;
    }
}
