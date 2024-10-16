package com.emazon.car.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingCar {

    private Long carId;
    private String userEmail;
    private List<Item> items;
    private LocalDateTime lastUpdate;

    public ShoppingCar() {}

    public ShoppingCar(String userEmail, List<Item> items, LocalDateTime lastUpdate) {
        this.userEmail = userEmail;
        this.items = items;
        this.lastUpdate = lastUpdate;
    }

    public ShoppingCar(Item item, String emailUser) {
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
