package com.emazon.car.adapters.driven.jpa.mysql.adapter;

import com.emazon.car.adapters.driven.jpa.mysql.entity.CarEntity;
import com.emazon.car.adapters.driven.jpa.mysql.entity.ItemEntity;
import com.emazon.car.adapters.driven.jpa.mysql.mapper.ICarEntityMapper;
import com.emazon.car.adapters.driven.jpa.mysql.mapper.IItemEntityMapper;
import com.emazon.car.adapters.driven.jpa.mysql.repository.ICarRepository;
import com.emazon.car.domain.model.Item;
import com.emazon.car.domain.model.ShoppingCar;
import com.emazon.car.domain.spi.ICarPersistencePort;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CarAdapter implements ICarPersistencePort {

    private final ICarEntityMapper mapper;
    private final IItemEntityMapper itemEntity;
    private final ICarRepository repository;

    @Override
    public void addItem(Item item, String userEmail) {
        CarEntity carEntity = repository.findByUserEmail(userEmail);

        List<ItemEntity> itemInCar = carEntity.getItems();

        Optional<ItemEntity> itemPresent = itemInCar.stream()
                .filter(article -> article.getArticleId().equals(item.getItemId()))
                .findFirst();

        if (itemPresent.isPresent()) {
            itemPresent.get().setQuantity(itemPresent.get().getQuantity() + item.getQuantity());
        }else {
            itemInCar.add(itemEntity.toItemEntity(item));
        }

        carEntity.setLastUpdate(LocalDateTime.now());
        repository.save(carEntity);

    }

    @Override
    public boolean carExists(String userEmail) {
        return repository.findByUserEmail(userEmail) != null;
    }

    @Override
    public void saveCar(ShoppingCar car) {
        repository.save(mapper.toCarEntity(car));
    }
}
