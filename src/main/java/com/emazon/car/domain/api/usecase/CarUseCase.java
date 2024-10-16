package com.emazon.car.domain.api.usecase;

import com.emazon.car.domain.api.ICarServicePort;
import com.emazon.car.domain.exception.LimitCategoryException;
import com.emazon.car.domain.exception.NotStockEnoughException;
import com.emazon.car.domain.model.Item;
import com.emazon.car.domain.model.ShoppingCar;
import com.emazon.car.domain.spi.IAuthenticationManager;
import com.emazon.car.domain.spi.ICarPersistencePort;
import com.emazon.car.domain.spi.ITransactionDatePort;
import com.emazon.car.domain.spi.IValidationStockPort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarUseCase implements ICarServicePort {

    private final ICarPersistencePort carPersistencePort;
    private final IValidationStockPort validationStockPort;
    private final ITransactionDatePort transactionDatePort;
    private final IAuthenticationManager authenticationManager;

    public CarUseCase(ICarPersistencePort carPersistencePort, IValidationStockPort validationStockPort,ITransactionDatePort transactionDatePort, IAuthenticationManager authenticationManager) {
        this.carPersistencePort = carPersistencePort;
        this.validationStockPort = validationStockPort;
        this.transactionDatePort = transactionDatePort;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void addItem(Item item) {

        if (!validationStockPort.validateStock(item.getArticleId(), item.getQuantity())) {
            throw new NotStockEnoughException(transactionDatePort.dateToUpdateStock(item.getArticleId()).toString());
        }
        if(!validationStockPort.validationLimitCategory(item.getArticleId())){
            throw new LimitCategoryException("Limite excedido");
        }
        if (carPersistencePort.carExists("Marina@example.com")){
            carPersistencePort.addItem(item, "Marina@example.com");
        } else {
            ShoppingCar shoppingCar = crateNewCar("Marina@example.com", item);
            carPersistencePort.saveCar(shoppingCar);
        }


    }

    public ShoppingCar crateNewCar(String userEmail, Item item) {

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);

        return new ShoppingCar(userEmail, itemList,LocalDateTime.now());

    }
}
