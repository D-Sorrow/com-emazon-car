package com.emazon.car.domain.spi;

import com.emazon.car.domain.model.Item;
import com.emazon.car.domain.model.ShoppingCar;

public interface ICarPersistencePort {

    void addItem(Item item, String userEmail);

    boolean carExists(String userEmail);

    void saveCar(ShoppingCar car);
}
